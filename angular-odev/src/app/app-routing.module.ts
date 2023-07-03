import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategoryListComponent } from './category/category-list/category-list.component';
import { CommentListComponent } from './comment/comment-list/comment-list.component';
import { PostListComponent } from './post/post-list/post-list.component';
import { UserListComponent } from './user/user-list/user-list.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { UserAddComponent } from './user/user-add/user-add.component';

const routes: Routes = [
  { path: 'user-list', component: UserListComponent },
  { path : '', redirectTo: 'user-list',pathMatch: 'full'},
  { path: 'category-list', component: CategoryListComponent },
  { path: 'post-list', component: PostListComponent },
  { path: 'comment-list', component: CommentListComponent },
  { path: 'user-add', component: UserAddComponent },
  { path: '**', component:NotFoundComponent},
  
];

@NgModule({
  
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
