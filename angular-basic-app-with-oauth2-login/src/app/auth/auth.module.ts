import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OAuthService } from 'angular-oauth2-oidc';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
  ],
  providers: [
    OAuthService
  ]
})
export class AuthModule { }
