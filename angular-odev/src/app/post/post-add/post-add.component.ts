import { Component } from '@angular/core';
import { PostService } from '../post-list/post.service';
import { Posts } from '../post-list/post';
import { UserService } from 'src/app/user/user.service';
import { Users } from 'src/app/user/user-list/user';
import { Comments } from 'src/app/comment/comment-list/comment';
import { CommentListComponent } from 'src/app/comment/comment-list/comment-list.component';
import { CommentService } from 'src/app/comment/comment-list/comment.service';

@Component({
  selector: 'app-post-add',
  templateUrl: './post-add.component.html',
  styleUrls: ['./post-add.component.css']
})
export class PostAddComponent {

  newPost: Posts = {
    post_id: 0,
    user_id: 0,
    category_id: 0,
    title: '',
    content: '',
    view_count: 0,
    creation_date: '',
    is_published: false
  };

  users: Users[] = [];
  posts : Posts[] = []
  selectedPostId: number | null = null;
  isEditing = false;
  comments: Comments[] = [];
  constructor(private postService: PostService, private userService: UserService,private commentService: CommentService) {

    this.getCurrentDate();
    setInterval(() => {
      this.getCurrentDate();
    }, 1000);
  }

  ngOnInit(): void {
    this.users = this.userService.getUsers();
    this.posts = this.postService.getPosts();
    this.comments = this.commentService.getComments();
  }

  addPost(): void {
    console.log("burada2")
    // Add validation or other logic before adding the post
    this.postService.addPost(this.newPost);
    
    // Reset the newPost object or redirect to the post list page
    this.resetForm();
  }

  resetForm(): void {
      console.log("burada1")
    this.newPost = {
      post_id: 0,
      user_id: 0,
      category_id: 0,
      title: '',
      content: '',
      view_count: 0,
      creation_date: Date().toLocaleString(),
      is_published: false
    };
  }

  editPost(postId: number): void {
    this.isEditing = true;
    this.selectedPostId = postId;
  }

  getCurrentDate(): string {
    return new Date().toLocaleString();
  }

  updatePost(post: Posts): void {
    // Add validation or other logic before updating the post
    this.postService.updatePost(post);
    this.selectedPostId = null;
    this.isEditing = false;
  }

  cancelEdit(): void {
    this.selectedPostId = null;
    this.isEditing = false;
  }

  deletePost(postId: number): void {
    const postHasComments = this.checkAssociatedDataPost(postId);
    if (postHasComments) {
      alert('This post has comments. It cannot be deleted.');
    } else {
      const confirmDelete = confirm('Are you sure you want to delete this post?');
      if (confirmDelete) {
        this.postService.deletePost(postId);
        this.cancelEdit();
      }
    }
  }

  public checkAssociatedDataPost(postId: number): boolean {
    // Check if the post has associated comments
    const hasAssociatedComments = this.checkPostHasComments(postId);

    return hasAssociatedComments;
  }

  private checkPostHasComments(postId: number): boolean {
    const postComments = this.comments.filter(comment => comment.post_id === postId);
    return postComments.length > 0;
  }

  
}
