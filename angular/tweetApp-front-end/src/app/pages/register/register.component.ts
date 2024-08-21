import { Component } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationRequest } from'src/app/models/AuthenticationRequest';
import { AuthenticationService } from'src/app/services/authentication.service';
import { ServiceResponse } from'src/app/models/ServiceResponse';
import { first } from 'rxjs';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent 
{

  message='';
  alertClass='';

  constructor(private formBuilder: FormBuilder, private router: Router, private authService: AuthenticationService)
  {
  }

  registerForm = this.formBuilder.group({
    firstName: ['', Validators.required],
    lastName: ['', Validators.required],
    username: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(6)]],
    phoneNumber: ['', [Validators.required, Validators.minLength(10)]]
    
  });

  get firstName()
  {
    return this.registerForm.get('firstName');
  }
  get lastName()
  {
    return this.registerForm.get('lastName');
  }

  get username()
  {
    return this.registerForm.get('username');
  }

  get email()
  {
    return this.registerForm.get('email');
  }

  get password()
  {
    return this.registerForm.get('password');
  }
  get phoneNumber()
  {
    return this.registerForm.get('phoneNumber');
  }
  
  

  onRegisterHandler()
  {
    console.log(this.registerForm.value)
    this.authService.register(this.registerForm.value).subscribe(
      (response: any) =>
        {
          if(response.user)
            {
              this.router.navigate(['/login']);
            }
            else
            {
              this.message = response.message;
              this.alertClass = 'alert alert-danger';
            }
        }, (error)=>
          {
            this.message = "something went wrong. Please try again"
            this.alertClass = 'alert alert-danger';
          }
    )
  }

}
