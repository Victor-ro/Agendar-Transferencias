import { ScheduledTransfer } from '../../models/scheduled-transfer';
import { ScheduleBackendService } from './../../shared/services/schedule-backend.service';
import { Component, OnInit } from '@angular/core';
import { CommonModule } from "@angular/common";
import { Observable } from 'rxjs';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
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

  createForm() {
    this.scheduleForm = this.fb.group({
      originAccount: ['', [Validators.required, this.accountValidatorNumbers]],
      destinationAccount: ['', [Validators.required, this.accountValidatorNumbers]],
      transferAmount: ['', [Validators.required]],
      transferDate: ['', [Validators.required]],
    });
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
