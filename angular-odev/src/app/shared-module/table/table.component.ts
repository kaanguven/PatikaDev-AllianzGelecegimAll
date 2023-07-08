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
}
