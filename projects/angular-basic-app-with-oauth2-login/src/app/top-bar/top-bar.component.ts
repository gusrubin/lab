import { Component, OnInit } from '@angular/core';
import { AppComponent } from '../app.component';
import { HttpHeaders } from '@angular/common/http';
import { OidcSecurityService } from 'angular-auth-oidc-client';

@Component({
  selector: 'app-top-bar',
  templateUrl: './top-bar.component.html',
  styleUrls: ['./top-bar.component.scss']
})
export class TopBarComponent implements OnInit {

  title = '';

  constructor(private appComponent: AppComponent, 
    private oidcSecurityService: OidcSecurityService) {
  }

  ngOnInit(): void {
    this.title = this.appComponent.title;
  }

  getToken() {
    const token = this.oidcSecurityService.getAccessToken().subscribe((token) => {
      const httpOptions = {
        headers: new HttpHeaders({
          Authorization: 'Bearer ' + token,
        }),
      };
    });
    console.log("token " + token);

  }

  logout() {
  }

  get isLoggedIn() {
    return null;
  }

  handleLoginClick = () => null;

  get claims() {
    let claims = null;
    console.log("claims=", claims);
    return claims;
  }
}
