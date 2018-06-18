import { Component } from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {AuthenticationService} from './services/authentication.service'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';

  constructor(private auth: AuthenticationService) {
    this.auth.authenticate(undefined, undefined);
  }
}
