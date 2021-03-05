import { TestBed } from '@angular/core/testing';

import { TokenhandlerforhttpreqService } from './tokenhandlerforhttpreq.service';

describe('TokenhandlerforhttpreqService', () => {
  let service: TokenhandlerforhttpreqService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TokenhandlerforhttpreqService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
