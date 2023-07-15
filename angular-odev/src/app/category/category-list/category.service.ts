import { Injectable } from '@angular/core';
import { Categories } from './category';
import { Posts } from 'src/app/post/post-list/post';
import { PostService } from 'src/app/post/post-list/post.service';
@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  constructor(private postService: PostService) { }
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


    addCategory(category: Categories) {
      this.categoryList.push(category);
    }
    getPostCount(categoryId: number): number {

      return this.postService.getPostCountByCategory(categoryId);
    }
    deleteCategory(categoryId: number): void {
      // Logic to delete the category with the specified categoryId
      // You can use the `findIndex` method to find the index of the category to delete
      const index = this.categoryList.findIndex(category => category.category_id === categoryId);
    
      // If the category exists, remove it from the array
      if (index !== -1) {
        this.categoryList.splice(index, 1);
      }
    }

    getCategoryByPostId(postId: number): string {
      const category = this.categoryList.find(category => category.category_id === postId);
      return category ? category.name : '';
    }
    
    getCategoryName(categoryId: number): string {
      //Normalde postların category id'si number geliyor ama biz eklediğimizde string tipinde ekliyoruz. "===" hem tipine hem değerine baktığı için bize boş dönüyor.
      //Bunun yerine "==" ile sadece değerine bakmayı sağladık.
      const category = this.categoryList.find(category => category.category_id == categoryId);
      return category ? category.name : '';
    }
}
