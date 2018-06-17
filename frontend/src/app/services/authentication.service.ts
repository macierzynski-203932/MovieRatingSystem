import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Configuration } from "../app.constants";

@Injectable()
export class AuthenticationService {

  authenticated = false;

  constructor(private http: HttpClient, private configuration: Configuration) {
  }

  authenticate(credentials, callback) {

        var url = this.configuration.ServerWithApiUrl + "/user";

        const headers = new HttpHeaders(credentials ? {
            authorization : 'Basic ' + btoa(credentials.username + ':' + credentials.password)
        } : {});

        this.http.get(url, {headers: headers}).subscribe(response => {
            if (response['name']) {
                this.authenticated = true;
            } else {
                this.authenticated = false;
            }
            return callback && callback();
        });
    }
}
