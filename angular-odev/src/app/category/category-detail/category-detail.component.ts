import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/user/user.service';
import { Users } from 'src/app/user/user-list/user';
import { Comments } from 'src/app/comment/comment-list/comment';
import { CommentService } from 'src/app/comment/comment-list/comment.service';
import { Categories } from 'src/app/category/category-list/category';
import { CategoryService } from 'src/app/category/category-list/category.service';
import { Posts } from 'src/app/post/post-list/post';
import { PostService } from 'src/app/post/post-list/post.service';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-category-detail',
  templateUrl: './category-detail.component.html',
  styleUrls: ['./category-detail.component.css']
})
export class CategoryDetailComponent implements OnInit {
  post_count!: number;
  categories : Categories[] = []
  categoryId: number = 0;
  constructor(private route: ActivatedRoute,private categoryService: CategoryService,private router: Router) { }

  ngOnInit(): void {
    this.categories = this.categoryService.getCategories();
    this.route.paramMap.subscribe(params => {
      this.categoryId = +params.get('id')!;
      this.post_count = this.categoryService.getPostCount(this.categoryId);
    });
  }

  postsBelongCategory(categoryId: number): void {
    this.router.navigate(['category-detail/category-posts', this.categoryId]);
  }

}