import { ScheduledTransfer } from '../../models/scheduled-transfer';
import { ScheduleBackendService } from './../../shared/services/schedule-backend.service';
import { Component, OnInit } from '@angular/core';
import { CommonModule } from "@angular/common";
import { Observable } from 'rxjs';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-schedule-frontend',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './schedule-frontend.component.html',
  styleUrl: './schedule-frontend.component.scss',
})
export class ScheduleFrontendComponent implements OnInit {

  transfers$ = new Observable<ScheduledTransfer[]>();

  currentDate: Date;

  scheduleForm!: FormGroup;

  submitted = false;


  ngOnInit(): void {
    this.createForm();
    this.getTransfers();
  }

  constructor(private scheduleBackendService: ScheduleBackendService, private fb: FormBuilder) {
    this.currentDate = new Date();
  }

  createForm() {
    this.scheduleForm = this.fb.group({
      originAccount: ['', [Validators.required, Validators.min(100000), Validators.max(999999)]],
      destinationAccount: ['', [Validators.required, Validators.min(100000), Validators.max(999999)]],
      transferAmount: ['', [Validators.required]],
      transferDate: ['', [Validators.required]],
    })
  }

  getTransfers() {
    this.transfers$ = this.scheduleBackendService.getScheduledTransfers();
  }

  submit() {
    this.submitted = true;

    if (this.scheduleForm.invalid) {
      return
    } else {
      this.scheduleBackendService.sendScheduleTransfer(this.scheduleForm.value).subscribe();
      alert("Agendamento cadastrado!")
      this.scheduleForm.reset();
    }

  }


}
