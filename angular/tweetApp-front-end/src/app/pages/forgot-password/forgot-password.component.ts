import { Component } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';
@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent {

  message='';
  alertClass='';

  constructor(private authService: AuthenticationService, private formBuilder: FormBuilder, private router: Router ){}

  forgotPasswordForm = this.formBuilder.group({
    username: ['', Validators.required],
    password: ['', [Validators.required, Validators.minLength(6)] ],
    confirmPassword: ['', [Validators.required, Validators.minLength(6)]]
  });

  get password()
  {
    return this.forgotPasswordForm.get('password');
  }

  get confirmPassword()
  {
    return this.forgotPasswordForm.get('confirmPassword');
  }

  get username()
  {
    return this.forgotPasswordForm.get('username');
  }

 

  onSetPassword()
  {
    console.log(this.forgotPasswordForm.value);
    this.authService.setPassword(this.forgotPasswordForm.value).subscribe((response: any) => 
      {
          
         if(response)
          {
             this.message = response.message;
              this.alertClass = 'alert alert-success';
              this.router.navigate(['/login']);
           }
            
    },(error)=>{
      this.message = 'failed, user does not exist!';
      this.alertClass = 'alert alert-danger';
    });
  }


}
