import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserRestrictedInfoComponent } from './user-restricted-info.component';

describe('UserRestrictedInfoComponent', () => {
  let component: UserRestrictedInfoComponent;
  let fixture: ComponentFixture<UserRestrictedInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserRestrictedInfoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserRestrictedInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
