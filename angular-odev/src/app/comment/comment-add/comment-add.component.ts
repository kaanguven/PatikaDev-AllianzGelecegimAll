import { Component } from '@angular/core';
import { Comments } from '../comment-list/comment';
import { CommentService } from '../comment-list/comment.service';
import { Posts } from '../../post/post-list/post';
import { PostService } from 'src/app/post/post-list/post.service';
@Component({
  selector: 'app-comment-add',
  templateUrl: './comment-add.component.html',
  styleUrls: ['./comment-add.component.css']
})
export class CommentAddComponent {
  comment: string = '';
  selectedPostId: number = 0;
  allPostsId: number[] = [];

  constructor(
    private commentService: CommentService,
    private postService: PostService
  ) {}

  ngOnInit(): void {
    this.allPostsId = this.postService.getAllPostIds();
  }

  addComment(): void {
    this.commentService.addComment(this.selectedPostId, this.comment);
    this.comment = '';
    this.selectedPostId = 0;
  }
}
