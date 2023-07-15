import { Component, Input,Output,EventEmitter } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent {
  @Input() data!: any[];
  @Input() columns!: string[];
  @Output() editCategoryClicked: EventEmitter<any> = new EventEmitter<any>();
  @Output() editUserClicked: EventEmitter<any> = new EventEmitter<any>();
  @Output() updateUserClicked: EventEmitter<any> = new EventEmitter<any>();
  @Output() removeUserClicked: EventEmitter<any> = new EventEmitter<any>();
  @Output() editPostClicked: EventEmitter<any> = new EventEmitter<any>();
  @Output() deletePostClicked: EventEmitter<any> = new EventEmitter<any>();
  @Output() updatePostClicked: EventEmitter<any> = new EventEmitter<any>();
  @Output() deleteCategoryClicked: EventEmitter<any> = new EventEmitter<any>();
  @Input() categoryPosts!: string[]; 
  constructor(private router: Router) {}

  deleteComment(commentId: number): void {
    const index = this.data.findIndex(item => item.comment_id === commentId);
    if (index !== -1) {
      this.data.splice(index, 1);
    }

  
  }
  editCategory(category: any): void {
    this.editCategoryClicked.emit(category);
  }


  editUser(user: any): void {
    this.editUserClicked.emit(user);
  }

  updateUser(user: any): void {
    this.updateUserClicked.emit(user);
  }

  removeUser(user: any): void {
    this.removeUserClicked.emit(user);
  }

  editPost(post: any): void {
    this.editPostClicked.emit(post);
  }
  
  deletePost(post: any): void {
    this.deletePostClicked.emit(post.post_id);
  }

  updatePost(post: any): void {
    this.updatePostClicked.emit(post);
  }

 deleteCategory(categoryId: number): void {
  console.log('Delete Category Clicked:', categoryId);
  this.deleteCategoryClicked.emit(categoryId);
}
  
  
  
  

  
}
