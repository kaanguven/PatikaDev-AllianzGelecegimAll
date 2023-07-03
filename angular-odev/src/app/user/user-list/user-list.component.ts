import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Users } from './user';
import { TableComponent } from 'src/app/shared-module/table/table.component';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css'],
  template: `
    <h1>Kullanıcılar</h1>
    <app-tablo></app-tablo>
  `
})
export class UserListComponent implements OnInit {

  users: Users[] = [];
  
  constructor(private userService: UserService) { }


 ngOnInit(): void {
     this.users = this.userService.getUsers();
 }

}

