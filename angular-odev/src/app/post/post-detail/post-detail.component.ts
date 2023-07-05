import { Component, OnInit } from '@angular/core';
import { PostService } from '../post-list/post.service';
import { Posts } from '../post-list/post';
import { ActivatedRoute } from '@angular/router';
import { Users } from 'src/app/user/user-list/user';
import { UserService } from 'src/app/user/user.service';
import { Comments } from 'src/app/comment/comment-list/comment';
import { CommentService } from 'src/app/comment/comment-list/comment.service';
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
  constructor(
    private postService: PostService,
    private route: ActivatedRoute,
    private userService: UserService,
    private commentService: CommentService,
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
      console.log(this.comments)
    });
  }

}