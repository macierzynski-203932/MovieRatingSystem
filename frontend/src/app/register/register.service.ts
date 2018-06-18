import { Injectable } from '@angular/core';
import { HttpService } from '../services/http.service';
import { Configuration } from '../app.constants';
import { User } from './models/user';
import { Router } from "@angular/router";

@Injectable()
export class RegisterService {

  constructor(private httpService: HttpService,
              private configuration: Configuration,
              private router: Router) { }

  registerUser(data: User) {
    var url = this.configuration.ServerWithApiUrl + "/user/register/";
    this.httpService.post<User>(url, data, {withCredentials: true}).subscribe( response => {
      this.router.navigateByUrl('/login');
    });
  }

}
