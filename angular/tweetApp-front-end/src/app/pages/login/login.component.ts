import { Component } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationRequest } from 'src/app/models/AuthenticationRequest';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { ServiceResponse } from 'src/app/models/ServiceResponse';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  message='';
  alertClass='';

  authenticationRequest: AuthenticationRequest = {};
  constructor(private formBuilder: FormBuilder, private router: Router, private authService: AuthenticationService)
  {}

  loginForm = this.formBuilder.group({

    username: ['', Validators.required],
    password: ['', [Validators.required, Validators.minLength(6)]]
  });

  get username()
  {
    return this.loginForm.get('username');
  }

  get password()
  {
    return this.loginForm.get('password');
  }

  onLoginHandler()
  {
    this.authService.login(this.loginForm.value).subscribe((response)=>
    {
      this.message = response.message;
      this.alertClass = 'alert alert-success';
      localStorage.setItem('token', response.token);
      localStorage.setItem('id', response.id);
      localStorage.setItem('username', response.username);
      this.router.navigateByUrl('/profile');
    }, (error)=>{
      this.message = 'login failed, please try again';
      this.alertClass = 'alert alert-danger';
    });
  }
  

}
