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

  constructor(private route: ActivatedRoute, private commentService: CommentService, private userService: UserService) { }

  ngOnInit(): void {
    const commentIdParam = this.route.snapshot.paramMap.get('commentId');
    this.commentId = commentIdParam ? +commentIdParam : null;
    console.log(this.commentId)
    this.userId = this.commentService.getUserIDByCommentID(this.commentId)
    this.userName = this.userService.getUserName(this.userId)
  }
}
