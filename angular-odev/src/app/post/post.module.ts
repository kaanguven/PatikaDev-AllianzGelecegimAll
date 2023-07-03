import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedModuleModule } from '../shared-module/shared-module.module';
import { PostListComponent } from './post-list/post-list.component';

@NgModule({
  declarations: [
    PostListComponent
  ],
  imports: [
    CommonModule,
    SharedModuleModule
  ]
})
export class PostModule { }
