import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import { AuthenticationService } from './authentication.service';

@Injectable()
export class HttpService {

  constructor(private http: HttpClient, private auth: AuthenticationService) {
  }

  authenticatedGet<T>(endpoint: string, httpOptions = {}): Observable<T> {

    const options = {
      headers: new HttpHeaders({
        'Authorization': 'Basic ' + this.auth.storedCredentials
      })
    };

    Object.assign(options, httpOptions);

    return this.http.get<T>(endpoint, {
      ...options
    });
  }

  get<T>(endpoint: string, httpOptions = {}): Observable<T> {
    return this.http.get<T>(endpoint, {
      ...httpOptions
    });
  }

  authenticatedPost<T>(endpoint: string, body = {}, httpOptions = {}): Observable<T> {
    
    const options = {
      headers: new HttpHeaders({
        'Authorization': 'Basic ' + this.auth.storedCredentials
      })
    };

    Object.assign(options, httpOptions);
    
    return this.http.post<T>(endpoint, body, {
      ...options
    });
  }

  post<T>(endpoint: string, body, httpOptions = {}): Observable<T> {
    return this.http.post<T>(endpoint, body, {
      ...httpOptions
    });
  }

  put<T>(endpoint: string, body, httpOptions = {}): Observable<T> {
    return this.http.put<T>(endpoint, body, {
      ...httpOptions
    });
  }

  delete<T>(endpoint: string, httpOptions = {}) {
    return this.http.delete<T>(endpoint, {
      ...httpOptions
    });
  }
}
