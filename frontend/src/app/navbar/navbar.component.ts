import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';
import { HttpService } from '../services/http.service';
import { HttpClient } from '@angular/common/http';
import { Router } from "@angular/router";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(public authenticationService: AuthenticationService,  private http: HttpService, private router: Router) {}

  ngOnInit() {
  }

  logout() {
    this.http.authenticatedPost("http://localhost:8080/logout", undefined, {withCredentials: true}).subscribe( () => {
      this.authenticationService.authenticated = false;
      this.authenticationService.authenticatedUser = "";
      this.authenticationService.storedCredentials = "";
      this.router.navigateByUrl('/login')
    });
  }
}
