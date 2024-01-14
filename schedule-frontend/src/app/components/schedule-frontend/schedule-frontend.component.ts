import { ScheduledTransfer } from '../../models/scheduled-transfer';
import { ScheduleBackendService } from './../../shared/services/schedule-backend.service';
import { Component, OnInit } from '@angular/core';
import { CommonModule } from "@angular/common";
import { AbstractControl, FormBuilder, FormControl, FormGroup, ValidatorFn, Validators } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-schedule-frontend',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './schedule-frontend.component.html',
  styleUrl: './schedule-frontend.component.scss',
})
export class ScheduleFrontendComponent implements OnInit {


  currentDate: Date;

  scheduleForm!: FormGroup;

  submitted = false;


  ngOnInit(): void {
    this.createForm();
  }

  constructor(private scheduleBackendService: ScheduleBackendService, private fb: FormBuilder, private router: Router) {
    this.currentDate = new Date();
  }

  accountValidatorNumbers(control: FormControl) {
    const value = control.value;

    const isValidFormat = /^0*[0-9]{6}$/.test(value);

    return isValidFormat ? null : { invalidAccount: true };
  }

  dateValidator(control: FormControl) {
    const selectedDate = new Date(control.value);
    const currentDate = new Date();

    selectedDate.setDate(selectedDate.getDate() + 1);

    if (selectedDate < currentDate) {
      return { 'invalidDate': true };
    }

    return null;
  }

  notEqualValidator(otherControlName: string): ValidatorFn {
    return (control: AbstractControl): { [key: string]: any } | null => {
      const otherControl = control.root.get(otherControlName);

      if (otherControl && control.value === otherControl.value) {
        return { notEqual: true };
      }

      return null;
    };
  }


  createForm() {
    this.scheduleForm = this.fb.group({
      originAccount: ['', [Validators.required, this.accountValidatorNumbers, Validators.pattern(/^[0-9]+$/), this.notEqualValidator('destinationAccount')]],
      destinationAccount: ['', [Validators.required, this.accountValidatorNumbers, Validators.pattern(/^[0-9]+$/), this.notEqualValidator('originAccount')]],
      transferAmount: ['', [Validators.required, Validators.min(20)]],
      transferDate: ['', [Validators.required, this.dateValidator]],
    });
  }

  formatCurrency(event: any): void {
    const input = event.target;
    const value = input.value.replace(/\D/g, '');
    const formattedValue = (+value / 100).toLocaleString('en-US', { style: 'currency', currency: 'USD' });
    input.value = formattedValue;
  }

  removeMaskAndSubmit() {
    const transferAmountControl = this.scheduleForm.get('transferAmount');

    const unmaskedValue = String(transferAmountControl?.value).replace(/\D/g, '');

    const numericValue = +unmaskedValue / 100;

    transferAmountControl?.setValue(numericValue);

    this.submit();
  }

  submit() {
    this.submitted = true;

    if (this.scheduleForm.invalid) {
      return
    } else {
      this.scheduleBackendService.sendScheduleTransfer(this.scheduleForm.value).subscribe();
      alert("Agendamento cadastrado!")
      this.submitted = false;
      this.scheduleForm.reset();
    }

  }

  navigateToTableComponent() {
    this.router.navigate(['table']);
  }

}
