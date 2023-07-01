import { Component,OnInit } from '@angular/core';
import { CategoryService } from './category.service';
import { Categories } from './category';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {

    categories : Categories[] = []
  constructor(private categoryService : CategoryService) {

    
  }

  ngOnInit(): void {
      this.categories = this.categoryService.getCategories();
  }



}
