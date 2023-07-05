import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedModuleModule } from '../shared-module/shared-module.module';
import { PostListComponent } from './post-list/post-list.component';
import { FormsModule } from '@angular/forms';
import { PostAddComponent } from './post-add/post-add.component';
import { RouterModule } from '@angular/router';
import { PostDetailComponent } from './post-detail/post-detail.component';
@NgModule({
  declarations: [
    PostListComponent,
    PostAddComponent ,
    PostDetailComponent
  ],
  imports: [
    CommonModule,
    SharedModuleModule,
    FormsModule,
    RouterModule
  ]
})
export class PostModule { }
