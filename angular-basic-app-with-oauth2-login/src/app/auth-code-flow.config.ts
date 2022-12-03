import { AuthConfig } from 'angular-oauth2-oidc';

export const authCodeFlowConfig: AuthConfig = {
  // URL of the Identity Provider
  issuer: 'http://localhost:8001',
  //issuer: 'http://localhost:8801/auth/realms/spring-angular-example/broker/azure-saml/endpoint',

  // URL of the SPA to redirect the user to after login
  //redirectUri: 'http://127.0.0.1:8001/login/oauth2/code/okta-idp',//'http://localhost:4200/',
  // redirectUri: window.location.origin + '/index.html',
  redirectUri: 'http://127.0.0.1:4200',
    // (localStorage.getItem('useHashLocationStrategy') === 'true'
    //   ? '/#/index.html'
    //   : '/index.html'),

  // The SPA's id. The SPA is registerd with this id at the auth-server
  // clientId: 'server.code',
  clientId: '798889dc-08c9-4153-af38-02b989ccc000',
  // clientId: 'messaging-client',

  // Just needed if your auth server demands a secret. In general, this
  // is a sign that the auth server is not configured with SPAs in mind
  // and it might not enforce further best practices vital for security
  // such applications.
  //dummyClientSecret: 'FCfx89*$t2',

  responseType: 'code',

  // set the scope for the permissions the client should request
  // The first four are defined by OIDC.
  // Important: Request offline_access to get a refresh token
  // The api scope is a usecase specific one
  // scope: 'openid profile email offline_access api',
  scope: 'openid profile email offline_access', // email profile roles web-origins',
//   scope: useSilentRefreshForCodeFlow
//     ? 'openid profile email api'
//     : 'openid profile email offline_access api',

  // ^^ Please note that offline_access is not needed for silent refresh
  // At least when using idsvr, this even prevents silent refresh
  // as idsvr ALWAYS prompts the user for consent when this scope is
  // requested

  // This is needed for silent refresh (refreshing tokens w/o a refresh_token)
  // **AND** for logging in with a popup
  //silentRefreshRedirectUri: `${window.location.origin}/silent-refresh.html`,

  //useSilentRefresh: useSilentRefreshForCodeFlow,

  showDebugInformation: true,

  //sessionChecksEnabled: false,

  //timeoutFactor: 0.01,
  // disablePKCI: true,

  //clearHashAfterLogin: true,
};