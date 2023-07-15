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

   
    const currentDate = new Date().toLocaleString();
    const newCategoryId = this.categoryService.getCategories().length + 1;

    const newCategory = {
      category_id: newCategoryId,
      name: this.categoryName,
      creation_date: currentDate
    };

    if (this.categoryName==null) {
      alert("Category name area can not be empty !")
      
    }else{
      this.categoryService.addCategory(newCategory);
    // Clear the input field after adding the category
      this.categoryName = '';

    }
    
  }
}
