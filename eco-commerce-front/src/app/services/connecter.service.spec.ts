import { TestBed } from '@angular/core/testing';

import { ConnecterService } from './connecter.service';

describe('ConnecterService', () => {
  let service: ConnecterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConnecterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
