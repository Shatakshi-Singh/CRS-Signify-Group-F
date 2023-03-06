import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChangeGradeComponentComponent } from './change-grade-component.component';

describe('ChangeGradeComponentComponent', () => {
  let component: ChangeGradeComponentComponent;
  let fixture: ComponentFixture<ChangeGradeComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChangeGradeComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChangeGradeComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
