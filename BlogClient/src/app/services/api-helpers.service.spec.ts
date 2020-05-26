import { TestBed } from '@angular/core/testing';

import { ApiHelpersService } from './api-helpers.service';

describe('ApiHelpersService', () => {
  let service: ApiHelpersService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApiHelpersService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
