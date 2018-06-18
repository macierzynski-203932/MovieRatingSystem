import { Component, OnInit } from '@angular/core';
import { User } from './models/user'
import { RegisterService } from './register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  public model: User = {
    name: '',
    surname: '',
    username: '',
    password: '',
    passwordConfirm: '',
    email: ''
  }

  constructor(private registerService: RegisterService) {}

  register() {  
    this.registerService.registerUser(this.model);
  }

}
