import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CurrentMedicationStockComponent } from './current-medication-stock.component';

describe('CurrentMedicationStockComponent', () => {
  let component: CurrentMedicationStockComponent;
  let fixture: ComponentFixture<CurrentMedicationStockComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CurrentMedicationStockComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CurrentMedicationStockComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
