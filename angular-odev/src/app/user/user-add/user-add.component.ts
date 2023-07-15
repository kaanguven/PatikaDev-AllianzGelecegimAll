import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Users } from '../user-list/user';
import { Comments } from 'src/app/comment/comment-list/comment';
import { CommentService } from 'src/app/comment/comment-list/comment.service';
import { Posts } from 'src/app/post/post-list/post';
import { PostService } from 'src/app/post/post-list/post.service';
import { ButtonComponent } from 'src/app/shared-module/button/button.component';
@Component({
  selector: 'app-user-add',
  templateUrl: './user-add.component.html',
  styleUrls: ['./user-add.component.css']
})
export class UserAddComponent implements OnInit {

  users: Users[] = [];
  newUser: Users = {} as Users;
  comments: Comments[] = [];
  posts: Posts[] = [];
  editingUser: Users | null = null;

  
  constructor(private userService: UserService,
    private commentService: CommentService,
    private postService: PostService
    ) { }

  ngOnInit(): void {
    this.users = this.userService.getUsers();
    this.comments = this.commentService.getComments();
    this.posts = this.postService.getPosts();
}

addUser(): void {
  // Assign a unique ID to the new user
  this.newUser.user_id = this.generateUserId();
  this.newUser.creation_date = new Date().toLocaleString();
  if (this.newUser.username==null || this.newUser.email==null) {
    alert("Username / Email areas cannot be empty!")
    
  }else {
    // Add the new user to the list
  if ( this.newUser.is_active !=true){
    this.newUser.is_active = false;
  }
  this.users.push(this.newUser);

  // Reset the newUser object
  this.newUser = {} as Users;
  }
  
  
}


generateUserId(): number {
  let maxId = 0;
  for (const user of this.users) {
    if (user.user_id > maxId) {
      maxId = user.user_id;
    }
  }
  return maxId + 1;
}


removeUser(user: Users): void {
  const index = this.users.indexOf(user);

  // Check if user has associated posts or comments
  const hasAssociatedData = this.checkAssociatedData(user);

  if (index !== -1 && !hasAssociatedData && this.users.length > 1) {
    this.users.splice(index, 1);
  } else {
    if (hasAssociatedData) {
      alert("Cannot delete user. User has associated posts or comments.");
    } else {
      alert("Cannot delete user. At least one user must remain.");
    }
  }
}

public checkAssociatedData(user: Users): boolean {
  // Check if the user has associated posts or comments
  const hasAssociatedPosts = this.checkUserHasPosts(user.user_id);
  const hasAssociatedComments = this.checkUserHasComments(user.user_id);

  return hasAssociatedPosts || hasAssociatedComments;
}

private checkUserHasPosts(userId: number): boolean {
  const userPosts = this.posts.filter(post => post.user_id === userId);
  return userPosts.length > 0;
}

private checkUserHasComments(userId: number): boolean {
  const userComments = this.comments.filter(comment => comment.user_id === userId);
  return userComments.length > 0;
}

editUser(user: Users): void {
  this.editingUser = { ...user };
  this.scrollToBottom();
}

updateUser(): void {
  if (this.editingUser) {
    const index = this.users.findIndex(user => user.user_id === this.editingUser?.user_id);
    if (index !== -1) {
      if (this.editingUser.username.trim() === '' || this.editingUser.email.trim() === '') {
        alert('Username and email cannot be empty');
        return;
      }
      
      const updatedUser: Users = {
        ...this.users[index],
        username: this.editingUser.username,
        email: this.editingUser.email
      };
      this.users[index] = updatedUser;
      this.editingUser = null;
    }
  }
}


scrollToBottom(): void {
  window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });
}

cancelEdit(): void {
  this.editingUser = null;
}
}