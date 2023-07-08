import { Component, Output, EventEmitter,Input } from '@angular/core';

@Component({
  selector: 'app-filter',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.css']
})
export class FilterComponent {
  @Input() placeHolder: string | null = null;
  @Input() options: string[] | null = null;
  @Output() filterApplied: EventEmitter<number | null> = new EventEmitter<number | null>();

  filterValue: number | null = null;

  applyFilter(): void {
    this.filterApplied.emit(this.filterValue);
  }
}