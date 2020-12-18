import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatPokepatientComponent } from './treat-pokepatient.component';

describe('TreatPokepatientComponent', () => {
  let component: TreatPokepatientComponent;
  let fixture: ComponentFixture<TreatPokepatientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TreatPokepatientComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatPokepatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
