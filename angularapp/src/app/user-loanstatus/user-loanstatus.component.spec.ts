import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserLoanstatusComponent } from './user-loanstatus.component';

describe('UserLoanstatusComponent', () => {
  let component: UserLoanstatusComponent;
  let fixture: ComponentFixture<UserLoanstatusComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserLoanstatusComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserLoanstatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
