import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TableComponent } from './table/table.component';
import { FilterComponent } from './filter/filter.component';
import { FormsModule } from '@angular/forms';
import { ButtonComponent } from './button/button.component';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [TableComponent, FilterComponent, ButtonComponent],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule
  ],
  exports: [TableComponent, FilterComponent,ButtonComponent]
})
export class SharedModuleModule { }
