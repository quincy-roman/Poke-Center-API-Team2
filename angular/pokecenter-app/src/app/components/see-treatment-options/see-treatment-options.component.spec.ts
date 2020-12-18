import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeeTreatmentOptionsComponent } from './see-treatment-options.component';

describe('SeeTreatmentOptionsComponent', () => {
  let component: SeeTreatmentOptionsComponent;
  let fixture: ComponentFixture<SeeTreatmentOptionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SeeTreatmentOptionsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SeeTreatmentOptionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
