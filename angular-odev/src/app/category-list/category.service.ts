import { Injectable } from '@angular/core';
import { Categories } from './category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor() { }

  private categoryList : Categories[] = [
      {
        category_id: 1,
        name: "Comedy",
        creation_date: "2018-06-12 20:41:48"
      },
      {
        category_id: 2,
        name: "Drama",
        creation_date: "2012-06-13 22:46:52"
      },
      {
        category_id: 3,
        name: "Horror",
        creation_date: "2012-10-06 03:23:23"
      },
      {
        category_id: 4,
        name: "Documentary",
        creation_date: "2012-09-07 22:47:49"
      }
    ]

    getCategories() {
      return this.categoryList;
    }
}
