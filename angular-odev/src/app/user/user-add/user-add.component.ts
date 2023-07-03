import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Users } from '../user-list/user';
import { Comments } from 'src/app/comment/comment-list/comment';
import { CommentService } from 'src/app/comment/comment-list/comment.service';
import { Posts } from 'src/app/post/post-list/post';
import { PostService } from 'src/app/post/post-list/post.service';
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
  // Add the new user to the list
  console.log("new user", this.newUser)
  this.users.push(this.newUser);

 
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
}