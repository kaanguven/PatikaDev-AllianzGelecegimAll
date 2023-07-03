import { Component, OnInit } from '@angular/core';
import { PostService } from './post.service';
import { Posts } from './post';
import { TableComponent } from '../../shared-module/table/table.component';

@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['./post-list.component.css']
})
export class PostListComponent implements OnInit {

  posts: Posts[] = [];
  
  constructor(private postService: PostService) { }


 ngOnInit(): void {
     this.posts = this.postService.getPosts();
 }

}