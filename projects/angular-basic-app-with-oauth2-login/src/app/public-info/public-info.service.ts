import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { of } from 'rxjs/internal/observable/of';
import { catchError, tap } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { PublicInfoDto } from './public-info-dto';

@Injectable({
  providedIn: 'root'
})
export class PublicInfoService {

  private apiBaseUrl = environment.publicInfoUri;

  constructor(private http: HttpClient) { }

  getPublicInfo(): Observable<PublicInfoDto> {
    console.log("apiBaseUrl=", this.apiBaseUrl);
    return this.http.get<PublicInfoDto>(this.apiBaseUrl)
      .pipe(
        tap(_ => console.log('fetched public info')),
        catchError(this.handleError<PublicInfoDto>('getPublicInfo'))
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
