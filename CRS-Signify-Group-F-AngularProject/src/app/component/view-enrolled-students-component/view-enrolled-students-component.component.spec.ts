import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewEnrolledStudentsComponentComponent } from './view-enrolled-students-component.component';

describe('ViewEnrolledStudentsComponentComponent', () => {
  let component: ViewEnrolledStudentsComponentComponent;
  let fixture: ComponentFixture<ViewEnrolledStudentsComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewEnrolledStudentsComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewEnrolledStudentsComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
