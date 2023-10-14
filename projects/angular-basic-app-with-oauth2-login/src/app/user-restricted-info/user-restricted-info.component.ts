import { Component, OnInit } from '@angular/core';
import { UserRestrictedInfoService } from './user-restricted-info.service';

@Component({
  selector: 'app-user-restricted-info',
  templateUrl: './user-restricted-info.component.html',
  styleUrls: ['./user-restricted-info.component.scss']
})
export class UserRestrictedInfoComponent implements OnInit {

  restrictedInfo: String = "";

  constructor(private userRestrictedInfoService: UserRestrictedInfoService) { }

  ngOnInit(): void {
    this.getPublicInfo();
  }

  getPublicInfo(): void {
    this.userRestrictedInfoService.getUserRestrictedInfo()
      .subscribe(restrictedInfo => this.restrictedInfo = restrictedInfo.response);
  }

}
