import { Component,Input, NgIterable } from '@angular/core';
import { Categories } from '../../category/category-list/category';
import { Comments } from '../../comment/comment-list/comment';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent {

  @Input() data!: any[];
  @Input() columns!: string[];

}
