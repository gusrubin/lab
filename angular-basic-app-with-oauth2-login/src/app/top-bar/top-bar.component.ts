import { Component, OnInit } from '@angular/core';
import { AppComponent } from '../app.component';
import { OAuthService } from 'angular-oauth2-oidc';

@Component({
  selector: 'app-top-bar',
  templateUrl: './top-bar.component.html',
  styleUrls: ['./top-bar.component.scss']
})
export class TopBarComponent implements OnInit {

  title = '';

  constructor(private appComponent: AppComponent, private oauthService: OAuthService) {
  }

  ngOnInit(): void {
    this.title = this.appComponent.title;
  }

  logout() {
    this.oauthService.logOut();
  }

  get isLoggedIn() {
    return !!this.oauthService.getIdToken();
  }

  handleLoginClick = () => this.isLoggedIn
    ? this.oauthService.logOut()
    : this.oauthService.initCodeFlow();

  get claims() {
    let claims = this.oauthService.getIdentityClaims() as any;
    console.log("claims=", claims);
    return claims;
  }
}
