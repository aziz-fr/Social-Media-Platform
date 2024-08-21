import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  constructor(private router: Router, public authService: AuthenticationService) { }

  onLogin()
  {
    this.router.navigateByUrl('login');
  }

  onLogout()
  {
    this.authService.logout();
    this.router.navigateByUrl('login');
  }
}
