import { TestBed } from '@angular/core/testing';

import { ScheduleBackendService } from './schedule-backend.service';

describe('ScheduleBackendService', () => {
  let service: ScheduleBackendService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ScheduleBackendService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
