import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedModuleModule } from '../shared-module/shared-module.module';
import { CommentListComponent } from './comment-list/comment-list.component';


@NgModule({
  declarations: [
    CommentListComponent
  ],
  imports: [
    CommonModule,
    SharedModuleModule
  ]
})
export class CommentModule { }
