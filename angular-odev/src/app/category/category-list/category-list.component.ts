import { Component,OnInit } from '@angular/core';
import { CategoryService } from './category.service';
import { Categories } from './category';
import { TableComponent } from '../../shared-module/table/table.component';
import { CategoryDetailComponent } from '../category-detail/category-detail.component';
import { Router } from '@angular/router';
import { Posts } from 'src/app/post/post-list/post';
import { PostService } from 'src/app/post/post-list/post.service';
@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {

    categories : Categories[] = []
    constructor(
      private categoryService: CategoryService,
      private postService: PostService,
      private router: Router
    ) {}
  ngOnInit(): void {
      this.categories = this.categoryService.getCategories();
  }
  
  

  goToCategoryDetail(categoryId: number): void {
    this.router.navigate(['/category-detail', categoryId]);
  }


}
