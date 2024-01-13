import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScheduleFrontendComponent } from './schedule-frontend.component';

describe('ScheduleFrontendComponent', () => {
  let component: ScheduleFrontendComponent;
  let fixture: ComponentFixture<ScheduleFrontendComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ScheduleFrontendComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ScheduleFrontendComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
