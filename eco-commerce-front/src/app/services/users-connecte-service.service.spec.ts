import { TestBed } from '@angular/core/testing';

import { UsersConnecteServiceService } from './users-connecte-service.service';

describe('UsersConnecteServiceService', () => {
  let service: UsersConnecteServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UsersConnecteServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
