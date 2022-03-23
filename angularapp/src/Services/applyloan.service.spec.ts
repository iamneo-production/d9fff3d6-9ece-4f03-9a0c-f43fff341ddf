import { TestBed } from '@angular/core/testing';

import { ApplyloanService } from './applyloan.service';

describe('ApplyloanService', () => {
  let service: ApplyloanService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApplyloanService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
