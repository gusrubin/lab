import { TestBed } from '@angular/core/testing';

import { UserRestrictedInfoService } from './user-restricted-info.service';

describe('UserRestrictedInfoService', () => {
  let service: UserRestrictedInfoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserRestrictedInfoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
