import { Injectable } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private cookie: CookieService,
  ) {
  }

  // initLoginFlow() {
  //   this.oauthService.initLoginFlow();
  // }

  logout() {
  }

  get isLoggedIn() {
    return null;
  }
  
  handleLoginClick = () => null;

  get claims() {
    return null;
  }

}
