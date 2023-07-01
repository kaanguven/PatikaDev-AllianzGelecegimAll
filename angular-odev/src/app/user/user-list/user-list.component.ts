import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Users } from './user';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: Users[] = [];
  
  constructor(private userService: UserService) { }


 ngOnInit(): void {
     this.users = this.userService.getUsers();
 }

}

