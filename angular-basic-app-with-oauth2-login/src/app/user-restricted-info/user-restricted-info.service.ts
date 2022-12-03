import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { of } from 'rxjs/internal/observable/of';
import { catchError, tap } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { UserRestrictedInfoDto } from './user-restricted-info-dto';
import { OAuthService } from 'angular-oauth2-oidc';

@Injectable({
  providedIn: 'root'
})
export class UserRestrictedInfoService {

  private apiBaseUrl = environment.userRestrictedInfoUri;

  constructor(private http: HttpClient, private oauthService: OAuthService) { }

  getHeaders() {
    const headers = {
      'Authorization':'Bearer ' + this.oauthService.getAccessToken()
    }
    console.log("header ", headers);
    return new HttpHeaders(headers);
  }

  getUserRestrictedInfo(): Observable<UserRestrictedInfoDto> {
    console.log("apiBaseUrl=", this.apiBaseUrl);
    return this.http.get<UserRestrictedInfoDto>(this.apiBaseUrl, { headers: this.getHeaders() })
      .pipe(
        tap(_ => console.log('fetched user restricted info')),
        catchError(this.handleError<UserRestrictedInfoDto>('getUserRestrictedInfo'))
      );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
