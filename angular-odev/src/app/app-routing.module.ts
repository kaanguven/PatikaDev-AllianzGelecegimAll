import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategoryListComponent } from './category/category-list/category-list.component';
import { CommentListComponent } from './comment/comment-list/comment-list.component';
import { PostListComponent } from './post/post-list/post-list.component';
import { UserListComponent } from './user/user-list/user-list.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { UserAddComponent } from './user/user-add/user-add.component';
import { PostDetailComponent } from './post/post-detail/post-detail.component';
import { PostAddComponent } from './post/post-add/post-add.component';
import { CategoryDetailComponent } from './category/category-detail/category-detail.component';
import { CategoryPostsComponent } from './category/category-posts/category-posts.component';
import { CommentAddComponent } from './comment/comment-add/comment-add.component';
import { CategoryAddComponent } from './category/category-add/category-add.component';
import { CommentDetailComponent } from './comment/comment-detail/comment-detail.component';
const routes: Routes = [
  { path: 'comment-detail/:commentId', component: CommentDetailComponent },
  { path: 'user-list', component: UserListComponent },
  { path: 'comment-add', component: CommentAddComponent },
  { path: 'category-add', component: CategoryAddComponent },
  { path: 'post-detail/:id', component: PostDetailComponent },
  { path : '', redirectTo: 'user-list',pathMatch: 'full'},
  { path: 'category-list', component: CategoryListComponent },
  { path: 'post-list', component: PostListComponent },
  { path: 'comment-list', component: CommentListComponent },
  { path: 'user-add', component: UserAddComponent },
  { path: 'post-add', component: PostAddComponent },
  { path: 'category-detail/:id', component: CategoryDetailComponent },
  { path: 'category-detail/category-posts/:id', component: CategoryPostsComponent },
  { path: '**', component:NotFoundComponent},
  
];

@NgModule({
  
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
