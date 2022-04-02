import { TestBed } from '@angular/core/testing';

import { UploaddocumentService } from './uploaddocument.service';

describe('UploaddocumentService', () => {
  let service: UploaddocumentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UploaddocumentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
