import { Loan,Document } from './loan';

describe('Loan', () => {
  it('should create an instance', () => {
    expect(new Loan()).toBeTruthy();
  });
});

describe('Document', () => {
  it('should create an instance', () => {
    expect(new Document()).toBeTruthy();
  });
});