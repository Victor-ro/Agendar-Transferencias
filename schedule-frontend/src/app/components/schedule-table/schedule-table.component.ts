import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { ScheduledTransfer } from '../../models/scheduled-transfer';
import { ScheduleBackendService } from '../../shared/services/schedule-backend.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-schedule-table',
  templateUrl: './schedule-table.component.html',
  styleUrl: './schedule-table.component.scss'
})
export class ScheduleTableComponent {

  transfers$ = new Observable<ScheduledTransfer[]>();


  ngOnInit(): void {
    this.getTransfers();
  }

  constructor(private scheduleBackendService: ScheduleBackendService, private router: Router) {
  }

  getTransfers() {
    this.transfers$ = this.scheduleBackendService.getScheduledTransfers();
  }

  navigateToMainComponent() {
    this.router.navigate(['']);
  }

}
