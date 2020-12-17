import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssignNurseComponent } from './assign-nurse.component';

describe('AssignNurseComponent', () => {
  let component: AssignNurseComponent;
  let fixture: ComponentFixture<AssignNurseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AssignNurseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AssignNurseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
