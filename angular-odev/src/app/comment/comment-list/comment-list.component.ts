import { Component, OnInit } from '@angular/core';
import { Comments } from './comment';
import { CommentService } from './comment.service';
@Component({
  selector: 'app-comment-list',
  templateUrl: './comment-list.component.html',
  styleUrls: ['./comment-list.component.css']
})
export class CommentListComponent implements OnInit {

  comments : Comments[] = [];

  constructor(private commentService: CommentService){

  }
 ngOnInit(): void {
     this.comments = this.commentService.getComments();
 }

 deleteComment(commentId: number): void {
  // CommentId'ye göre yorumu bulup listeden kaldırabilirsiniz
  const index = this.comments.findIndex(comment => comment.comment_id === commentId);
  if (index !== -1) {
    this.comments.splice(index, 1);
  }
}
 



}
