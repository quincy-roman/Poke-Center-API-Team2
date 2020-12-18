import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthorizeDischargeComponent } from './authorize-discharge.component';

describe('AuthorizeDischargeComponent', () => {
  let component: AuthorizeDischargeComponent;
  let fixture: ComponentFixture<AuthorizeDischargeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AuthorizeDischargeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthorizeDischargeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
