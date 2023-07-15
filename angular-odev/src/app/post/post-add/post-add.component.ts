import { Component } from '@angular/core';
import { PostService } from '../post-list/post.service';
import { Posts } from '../post-list/post';
import { UserService } from 'src/app/user/user.service';
import { Users } from 'src/app/user/user-list/user';
import { Comments } from 'src/app/comment/comment-list/comment';
import { CommentListComponent } from 'src/app/comment/comment-list/comment-list.component';
import { CommentService } from 'src/app/comment/comment-list/comment.service';
import { Categories } from 'src/app/category/category-list/category';
import { CategoryService } from 'src/app/category/category-list/category.service';

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
  posts : Posts[] = [];
  selectedPostId: number | null = null;
  isEditing = false;
  comments: Comments[] = [];
  categories : Categories[] = [];
  selectedPost: Posts | null = null;
  currentPage: number = 1;
  itemsPerPage: number = 10;
  totalPages: number = 1;
  paginatedPosts: Posts[] = [];
  constructor(private postService: PostService, private userService: UserService,private commentService: CommentService, private categoryService: CategoryService) {

    this.getCurrentDate();
    setInterval(() => {
      this.getCurrentDate();
    }, 1000);
  }

  ngOnInit(): void {
    this.users = this.userService.getUsers();
    this.posts = this.postService.getPosts();
    this.categories = this.categoryService.getCategories();
    this.comments = this.commentService.getComments();
    this.totalPages = Math.ceil(this.posts.length / this.itemsPerPage);
    this.updatePaginatedPosts();
  }

  updatedPost: Posts = {
    post_id: 0,
    user_id: 0,
    category_id: 0,
    title: '',
    content: '',
    view_count: 0,
    creation_date: '',
    is_published: false
  };
  addPost(): void {
    // Add validation or other logic before adding the post
    this.postService.addPost(this.newPost);
    
    // Reset the newPost object or redirect to the post list page
    this.resetForm();
    this.updatePaginatedPosts();
  }

  updatePaginatedPosts(): void {
    const startIndex = (this.currentPage - 1) * this.itemsPerPage;
    const endIndex = startIndex + this.itemsPerPage;
    this.paginatedPosts = this.posts.slice(startIndex, endIndex);
  }

  onPageChange(pageNumber: number): void {
    this.currentPage = pageNumber;
    this.updatePaginatedPosts();
  }

  resetForm(): void {
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

  editPost(post: Posts): void {
    this.updatedPost = { ...post }; // Create a copy of the post to be edited
    this.isEditing = true;
    this.scrollToBottom();
  }
  getCurrentDate(): string {
    return new Date().toLocaleString();
  }

  updatePost(): void {
    if (this.updatedPost) {
      if(this.updatedPost.title==null || this.updatedPost.title=='' ||
      this.updatedPost.content==null || this.updatedPost.content ==''  ){
        alert("Title or content areas must be filled ! ")

      }
      this.postService.updatePost(this.updatedPost);
      this.selectedPost = { ...this.updatedPost }; // Assign updatedPost to selectedPost
      this.isEditing = false;
      this.updatePaginatedPosts();

    }
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
    this.updatePaginatedPosts();
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

  scrollToBottom(): void {
    window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });
  }

  
 
}
