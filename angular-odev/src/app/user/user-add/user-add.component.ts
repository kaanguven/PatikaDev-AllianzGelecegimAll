import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Users } from '../user-list/user';

@Component({
  selector: 'app-user-add',
  templateUrl: './user-add.component.html',
  styleUrls: ['./user-add.component.css']
})
export class UserAddComponent implements OnInit {

  users: Users[] = [];
  newUser: Users = {} as Users;
  
  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.users = this.userService.getUsers();
}

addUser(): void {
  // Add the new user to the list
  console.log("new user", this.newUser)
  this.users.push(this.newUser);

 
}

removeUser(user: Users): void {
  // Find the index of the user in the list
  const index = this.users.indexOf(user);
  if (index !== -1) {
    // Remove the user from the list
    this.users.splice(index, 1);
  }
}


}
