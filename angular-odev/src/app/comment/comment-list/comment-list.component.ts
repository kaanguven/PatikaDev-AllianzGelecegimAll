import { Component, OnInit } from '@angular/core';
import { Comments } from './comment';
import { CommentService } from './comment.service';
import { PostService } from 'src/app/post/post-list/post.service';
import { Posts } from 'src/app/post/post-list/post';
@Component({
  selector: 'app-comment-list',
  templateUrl: './comment-list.component.html',
  styleUrls: ['./comment-list.component.css']
})
export class CommentListComponent implements OnInit {

  comments : Comments[] = [];
  currentPage: number = 1;
  itemsPerPage: number = 10;
  totalPages!: number;
  paginatedComments: Comments[] = [];

  constructor(private commentService: CommentService,private postService: PostService){

  }
 ngOnInit(): void {
     this.comments = this.commentService.getComments();
     this.totalPages = Math.ceil(this.comments.length / this.itemsPerPage);
     this.updatePaginatedComments();
 }


 updatePaginatedComments(): void {
  const startIndex = (this.currentPage - 1) * this.itemsPerPage;
  const endIndex = startIndex + this.itemsPerPage;
  this.paginatedComments = this.comments.slice(startIndex, endIndex);
}

onPageChange(pageNumber: number): void {
  this.currentPage = pageNumber;
  this.updatePaginatedComments();
}
 



}
