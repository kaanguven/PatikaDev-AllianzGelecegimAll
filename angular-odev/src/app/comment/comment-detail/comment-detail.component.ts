import { Component,OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommentService } from '../comment-list/comment.service';
import { UserService } from 'src/app/user/user.service';

@Component({
  selector: 'app-comment-detail',
  templateUrl: './comment-detail.component.html',
  styleUrls: ['./comment-detail.component.css']
})
export class CommentDetailComponent implements OnInit {
  commentId!: number | null;
  userId!: number | null;
  userName! :string | null; 
  commentData: { 'Comment ID': number, 'User ID': number, 'User Name': string }[] = [];

  constructor(private route: ActivatedRoute, private commentService: CommentService, private userService: UserService) { }

  ngOnInit(): void {
    const commentIdParam = this.route.snapshot.paramMap.get('commentId');
    this.commentId = commentIdParam ? +commentIdParam : null;
    this.userId = this.commentService.getUserIDByCommentID(this.commentId)
    this.userName = this.userService.getUserName(this.userId)
    this.populateCommentData();
  }

  private populateCommentData(): void {
    if (this.commentId && this.userId && this.userName) {
      this.commentData.push({
        'Comment ID': this.commentId,
        'User ID': this.userId,
        'User Name': this.userName
      });
    }
  }
}
