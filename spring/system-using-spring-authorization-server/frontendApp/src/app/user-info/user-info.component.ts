import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-user-info',
  providers: [AuthService],
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.scss']
})
export class UserInfoComponent implements OnInit {

  public isLoggedIn = false;

  constructor(private _service: AuthService) { }

  ngOnInit() {
    this.isLoggedIn = this._service.checkCredentials();
    let i = window.location.href.indexOf('code');
    if (!this.isLoggedIn && i != -1) {
      this._service.retrieveToken(window.location.href.substring(i + 5));
    }
  }

  login() {
    window.location.href = environment.oauth2IdpAuthorizeUri + '?' +
      'response_type=code&scope=openid%20write%20read&client_id=' + this._service.clientId +
      '&redirect_uri=' + this._service.redirectUri;
    // 'http://localhost:8083/auth/realms/baeldung/protocol/openid-connect/auth?' +
    // 'response_type=code&scope=openid%20write%20read&client_id=' +
    // this._service.clientId + '&redirect_uri=' + this._service.redirectUri;
  }

  logout() {
    this._service.logout();
  }

}
