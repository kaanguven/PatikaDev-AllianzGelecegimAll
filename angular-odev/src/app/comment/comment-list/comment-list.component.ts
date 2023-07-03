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



}
