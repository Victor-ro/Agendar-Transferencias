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

  scheduleForm!: FormGroup;


  ngOnInit(): void {
    this.createForm();
    this.getTransfers();
  }

  constructor(private scheduleBackendService: ScheduleBackendService, private fb: FormBuilder) {
  }

  createForm() {
    this.scheduleForm = this.fb.group({
      originAccount: ['', [Validators.required]],
      destinationAccount: ['', [Validators.required]],
      transferAmount: ['', [Validators.required]],
      transferDate: ['', [Validators.required]],
    })
  }

  getTransfers() {
    this.transfers$ = this.scheduleBackendService.getScheduledTransfers();
  }

  submit() {
    if (this.scheduleForm.valid) {
      this.scheduleBackendService.sendScheduleTransfer(this.scheduleForm.value).subscribe();
      this.scheduleForm.reset();
    }

  }


}
