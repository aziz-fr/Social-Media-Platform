import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from 'src/app/services/data.service';
import { IUser } from 'src/app/models/user.model';


@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent {

  users: IUser[] = [];

  constructor(private router: Router, private dataService: DataService) 
  {
    this.dataService.getUsers().subscribe((response: IUser[])=>{
      this.users = response;
    });
  }

  

}
