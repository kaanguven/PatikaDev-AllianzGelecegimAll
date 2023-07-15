import { Component } from '@angular/core';
import { CategoryService } from '../category-list/category.service';
@Component({
  selector: 'app-category-add',
  templateUrl: './category-add.component.html',
  styleUrls: ['./category-add.component.css']
})
export class CategoryAddComponent {
  categoryName!: string;

  constructor(private categoryService: CategoryService) {}

  addCategory() {
    if (this.categoryName === '' || this.categoryName == null) {
      alert("Category name cannot be empty!");
    } else {
      const currentDate = new Date().toLocaleString();
      const newCategoryId = this.categoryService.getCategories().length + 1;
  
      const newCategory = {
        category_id: newCategoryId,
        name: this.categoryName,
        creation_date: currentDate
      };
  
      this.categoryService.addCategory(newCategory);
      this.categoryName = '';
    }
  }
  
}
