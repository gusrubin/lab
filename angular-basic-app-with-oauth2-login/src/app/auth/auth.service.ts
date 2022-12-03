import { Injectable } from '@angular/core';
import { OAuthService } from 'angular-oauth2-oidc';
import { JwksValidationHandler } from 'angular-oauth2-oidc-jwks';
import { CookieService } from 'ngx-cookie-service';
import { authCodeFlowConfig } from '../auth-code-flow.config';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private cookie: CookieService,
    private oauthService: OAuthService
  ) {
    this.oauthService.configure(authCodeFlowConfig);
    this.oauthService.tokenValidationHandler = new JwksValidationHandler();
    this.oauthService.loadDiscoveryDocumentAndTryLogin();
  }

  // initLoginFlow() {
  //   this.oauthService.initLoginFlow();
  // }

  logout() {
    this.oauthService.logOut();
  }

  get isLoggedIn() {
    return !!this.oauthService.getIdToken();
  }
  
  handleLoginClick = () => this.isLoggedIn 
    ? this.oauthService.logOut()
    : this.oauthService.initLoginFlow();

  get claims() {
    return this.oauthService.getIdentityClaims() as any;
  }

}
