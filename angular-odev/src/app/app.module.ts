import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserModule } from './user/user.module';
import { NavbarComponent } from './navbar/navbar.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { SharedModuleModule } from './shared-module/shared-module.module';
import { PostModule } from './post/post.module';
import { CommentModule } from './comment/comment.module';
import { CategoryModule } from './category/category.module';
import { CategoryDetailComponent } from './category/category-detail/category-detail.component';
import { CategoryPostsComponent } from './category/category-posts/category-posts.component';
import { CommentAddComponent } from './comment/comment-add/comment-add.component';
import { CategoryAddComponent } from './category/category-add/category-add.component';
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    NotFoundComponent,
    CategoryPostsComponent,
    CommentAddComponent,
    CategoryAddComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    UserModule,
    FormsModule,
    SharedModuleModule,
    PostModule,
    CommentModule,
    CategoryModule 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
