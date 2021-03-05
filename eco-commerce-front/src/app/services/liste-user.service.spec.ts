import { TestBed } from '@angular/core/testing';

import { ListeUserService } from './liste-user.service';

describe('ListeUserService', () => {
  let service: ListeUserService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ListeUserService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
