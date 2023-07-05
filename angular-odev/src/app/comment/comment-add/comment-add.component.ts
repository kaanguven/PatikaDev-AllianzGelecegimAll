import { Component } from '@angular/core';
import { Comments } from '../comment-list/comment';
import { CommentService } from '../comment-list/comment.service';
@Component({
  selector: 'app-comment-add',
  templateUrl: './comment-add.component.html',
  styleUrls: ['./comment-add.component.css']
})
export class CommentAddComponent {
  comment: string = '';
  postId: number = 0;

  constructor(private commentService: CommentService) {}

  addComment(): void {
    this.commentService.addComment(this.postId, this.comment);
    this.comment = '';
    this.postId = 0;
  }
}
