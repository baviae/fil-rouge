import { TestBed } from '@angular/core/testing';

import { ProduitServiceService } from './produit-service.service';

describe('ProduitServiceService', () => {
  let service: ProduitServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProduitServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
