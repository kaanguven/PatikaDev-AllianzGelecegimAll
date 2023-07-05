import { Component, OnInit } from '@angular/core';
import { PostService } from './post.service';
import { Posts } from './post';
import { TableComponent } from '../../shared-module/table/table.component';
import { Router } from '@angular/router';
import { UserService } from 'src/app/user/user.service';
import { Users } from 'src/app/user/user-list/user';
import { Comments } from 'src/app/comment/comment-list/comment';
import { CommentService } from 'src/app/comment/comment-list/comment.service';
import { Categories } from 'src/app/category/category-list/category';
import { CategoryService } from 'src/app/category/category-list/category.service';
@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['./post-list.component.css']
})
export class PostListComponent implements OnInit {

  posts: Posts[] = [];
  users: Users[] = [];
  comments : Comments[] = [];
  categories : Categories[] = [];
  selectedUserId: number | null = null;
  selectedPostId: number | null = null;
  constructor(private postService: PostService,private userService: UserService,private commentService: CommentService,
    private categoryService: CategoryService,private router: Router) { }


 ngOnInit(): void {
     this.posts = this.postService.getPosts();
     this.users = this.userService.getUsers();
     this.comments = this.commentService.getComments();
     this.categories = this.categoryService.getCategories();
 }

 getUserName(userId: number | null): string {
  if (userId === null) {
    return ''; // userId null ise boş döndür
  }
  const user = this.users.find(u => u.user_id === userId);
  return user ? user.username : '';
}

getCategory(postId: number | null): string {
  if (postId === null) {
    return '';
  }
  const post = this.posts.find(p => p.post_id === postId);
  if (!post) {
    return '';
  }
  const category = this.categories.find(c => c.category_id === post.category_id);
  return category ? category.name : '';
}

getComment(userId: number | null): string[] {
  if (userId === null) {
    return [];
  }
  const userComments = this.comments.filter(comment => comment.user_id === userId);
  return userComments.map(comment => comment.comment);
}


showDetails(userId: number, postId: number): void {
  this.router.navigate(['/post-detail', postId], { queryParams: { userId: userId } });
}

}


 