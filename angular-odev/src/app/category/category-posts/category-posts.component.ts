import { Component,OnInit } from '@angular/core';
import { Posts } from 'src/app/post/post-list/post';
import { PostService } from 'src/app/post/post-list/post.service';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
@Component({
  selector: 'app-category-posts',
  templateUrl: './category-posts.component.html',
  styleUrls: ['./category-posts.component.css']
})
export class CategoryPostsComponent implements OnInit {

  categoryId!: number ;
  posts!: string[];
  constructor(private route: ActivatedRoute,private postService: PostService,private router: Router) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.categoryId = +params.get('id')!;
      this.posts = this.postService.getPostsByCategoryId(this.categoryId);
      console.log(this.categoryId)
    });
  }

}
