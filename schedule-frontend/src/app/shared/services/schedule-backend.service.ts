import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { ScheduledTransfer } from '../../models/scheduled-transfer';

@Injectable({
  providedIn: 'root'
})
export class ScheduleBackendService {

  private url = environment.api;

  constructor(private http: HttpClient) {

  }

  getScheduledTransfers(){
      return this.http.get<ScheduledTransfer[]>(this.url + '/financial-transfer');
  }

  sendScheduleTransfer(schedule: ScheduledTransfer){
    return this.http.post<ScheduledTransfer>(this.url + '/financial-transfer', schedule);
  }
}
