import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RemoveTrainerComponent } from './remove-trainer.component';

describe('RemoveTrainerComponent', () => {
  let component: RemoveTrainerComponent;
  let fixture: ComponentFixture<RemoveTrainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RemoveTrainerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RemoveTrainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
