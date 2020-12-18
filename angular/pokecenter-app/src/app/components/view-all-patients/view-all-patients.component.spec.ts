import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAllPatientsComponent } from './view-all-patients.component';

describe('ViewAllPatientsComponent', () => {
  let component: ViewAllPatientsComponent;
  let fixture: ComponentFixture<ViewAllPatientsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewAllPatientsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAllPatientsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
