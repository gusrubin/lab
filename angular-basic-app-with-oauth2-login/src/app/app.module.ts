import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CookieService } from 'ngx-cookie-service';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BottomBarComponent } from './bottom-bar/bottom-bar.component';
import { TopBarComponent } from './top-bar/top-bar.component';
import { HomeComponent } from './home/home.component';
import { PublicInfoComponent } from './public-info/public-info.component';
import { UserRestrictedInfoComponent } from './user-restricted-info/user-restricted-info.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AuthModule, EventTypes, LogLevel, PublicEventsService } from 'angular-auth-oidc-client';
import { filter } from 'rxjs';

@NgModule({
  declarations: [
    AppComponent,
    BottomBarComponent,
    TopBarComponent,
    HomeComponent,
    PublicInfoComponent,
    UserRestrictedInfoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    AuthModule.forRoot({
      config: {
        authority: 'http://localhost:8001',
        redirectUrl: 'http://127.0.0.1:4200',
        postLogoutRedirectUri: 'http://127.0.0.1:4200',
        clientId: '798889dc-08c9-4153-af38-02b989ccc000',
        scope: 'openid profile email offline_access',
        responseType: 'code',
        silentRenew: true,
        useRefreshToken: true,
        logLevel: LogLevel.Debug,
      },
    }),
  ],
  providers: [
    AppComponent,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { 
  constructor(private readonly eventService: PublicEventsService) {
    this.eventService
      .registerForEvents()
      .pipe(filter((notification) => notification.type === EventTypes.ConfigLoaded))
      .subscribe((config) => {
        console.log('ConfigLoaded', config);
      });
  }
}
