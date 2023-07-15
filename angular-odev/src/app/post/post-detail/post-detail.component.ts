import { Component, OnInit } from '@angular/core';
import { PostService } from '../post-list/post.service';
import { Posts } from '../post-list/post';
import { ActivatedRoute } from '@angular/router';
import { Users } from 'src/app/user/user-list/user';
import { UserService } from 'src/app/user/user.service';
import { Comments } from 'src/app/comment/comment-list/comment';
import { CommentService } from 'src/app/comment/comment-list/comment.service';
import { CategoryService } from 'src/app/category/category-list/category.service';
@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.css']
})
export class PostDetailComponent {

  postId!: number;
  userId!: number;
  post!: Posts;
  username!: string;
  postContent!: string;
  comments: string[] = []; 
  category!: string
  posts: { 'Post Category': string }[] = [];
  postsUser: { 'Post User': string }[] = [];
  postsComment: { 'Post Comments': string[] }[] = []
  postsContent: { 'Post Content': string }[] = [];
  combinedPosts: any[] = [];
  constructor(
    private postService: PostService,
    private route: ActivatedRoute,
    private userService: UserService,
    private commentService: CommentService,
    private categoryService: CategoryService,
  ) { }

  ngOnInit(): void {
    this.route.queryParamMap.subscribe(queryParams => {
      const postIdParam = this.route.snapshot.paramMap.get('id');
      const userIdParam = queryParams.get('userId');
      this.postId = postIdParam ? +postIdParam : 0;
      this.userId = userIdParam ? +userIdParam : 0;
      this.username = this.userService.getUserName(this.userId);
      this.postContent = this.postService.getPostContent(this.postId);
      this.comments =this.commentService.getCommentsByPostId(this.postId)
      const categoryId = this.postService.getCategoryId(this.postId);
      // console.log("CATEGORY",categoryId)
      this.category = this.categoryService.getCategoryName(categoryId);
      this.posts.push({'Post Category': this.category});
      this.postsUser.push({'Post User': this.username});
      this.postsContent.push({'Post Content': this.postContent});
      for (const comment of this.comments) {
        this.postsComment.push({ 'Post Comments': [comment] });
      }

      
      // Combine the data from posts and postsUser into a single array
      const combinedData = this.posts.map((post, index) => {
        const contentObj = this.postsContent[index];
        const commentObj = this.getAllComments();
        const userObj = this.postsUser[index];
        console.log(commentObj)
        return { ...post, ...contentObj, ...userObj, ...commentObj,'Post Comments': commentObj };
      });
      // Assign the combined data to a new property
      this.combinedPosts = combinedData;
     
      // console.log("NAME",this.category)
      // console.log(this.comments)
    });
  }
  private getAllComments(): string[] {
    const allComments: string[] = [];
    for (const commentObj of this.postsComment) {
      const comments = commentObj['Post Comments'];
      allComments.push(...comments);
    }
    return allComments;
  }
}