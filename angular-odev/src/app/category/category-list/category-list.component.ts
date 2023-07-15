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
    editingCategories: Categories | null = null;
    constructor(
      private categoryService: CategoryService,
      private postService: PostService,
      private router: Router
    ) {}
  ngOnInit(): void {
      this.categories = this.categoryService.getCategories();
  }
  
  

  goToCategoryDetail(categoryId: number): void {
    this.router.navigate(['/category-detail', categoryId], { state: { categoryId } });
  }


  editCategory(category: Categories): void {
    this.editingCategories = { ...category };
  }
  
    updateCategory(): void {
    if (this.editingCategories) {
      const index = this.categories.findIndex(category => category.category_id === this.editingCategories?.category_id
        );
      if (index !== -1) {
        if (this.editingCategories.name.trim() === '') {
          alert('Category name cannot be empty');
          return;
        }
        const updatedCategory: Categories = {
          ...this.categories[index],
          name: this.editingCategories.name,
         
        };
        this.categories[index] = updatedCategory;
        this.editingCategories = null;
      }
    }
  }
  deleteCategory(categoryId: number): void {
    const confirmDelete = confirm('Are you sure you want to delete this category?');
    if (confirmDelete) {
      this.categoryService.deleteCategory(categoryId);
      // Optional: You can also delete associated posts if needed
      // this.postService.deletePostsByCategoryId(categoryId);
    }
  }
  
  
  
  cancelEdit(): void {
    this.editingCategories = null;
  }
  }


