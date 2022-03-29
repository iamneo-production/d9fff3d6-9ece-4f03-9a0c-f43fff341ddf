import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserApplyLoanComponent } from './user-apply-loan.component';

describe('UserApplyLoanComponent', () => {
  let component: UserApplyLoanComponent;
  let fixture: ComponentFixture<UserApplyLoanComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserApplyLoanComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserApplyLoanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
