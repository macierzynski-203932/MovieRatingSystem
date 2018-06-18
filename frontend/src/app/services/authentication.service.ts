import { Injectable, Input, Output } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { RequestOptions } from '@angular/http';
import { Configuration } from "../app.constants";

@Injectable()
export class AuthenticationService {

    authenticated = false;
    authenticatedUser: string;
    storedCredentials: string;

  constructor(private http: HttpClient, private configuration: Configuration) {
  }

  authenticate(credentials, callback) {

        var url = this.configuration.ServerWithApiUrl + "/user";

        const headers = new HttpHeaders(credentials ? {
            authorization : 'Basic ' + btoa(credentials.username + ':' + credentials.password)
        } : {});

        this.storedCredentials = credentials ? btoa(credentials.username + ':' + credentials.password) : "";

        this.http.get(url, {headers: headers, withCredentials: true}).subscribe(response => {
            if (response['name']) {
                this.authenticated = true;
                this.authenticatedUser = response['name'];
            } else {
                this.authenticated = false;
            }
            return callback && callback();
        });
    }
}
