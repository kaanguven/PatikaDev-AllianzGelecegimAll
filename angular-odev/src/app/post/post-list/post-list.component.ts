import { Component, OnInit } from '@angular/core';
import { PostService } from './post.service';
import { Posts } from './post';
import { TableComponent } from '../../shared-module/table/table.component';
import { Router,ActivatedRoute,Params } from '@angular/router';
import { UserService } from 'src/app/user/user.service';
import { Users } from 'src/app/user/user-list/user';
import { Comments } from 'src/app/comment/comment-list/comment';
import { CommentService } from 'src/app/comment/comment-list/comment.service';
import { Categories } from 'src/app/category/category-list/category';
import { CategoryService } from 'src/app/category/category-list/category.service';
@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['./post-list.component.css']
})
export class PostListComponent implements OnInit {

  posts: Posts[] = [];
  users: Users[] = [];
  comments: Comments[] = [];
  categories: Categories[] = [];
  filteredPosts: Posts[] = [];
  currentPage: number = 1;
  itemsPerPage: number = 10;
  totalPages!: number;
  paginatedPosts: Posts[] = [];
  selectedUserId: number | null = null;
  selectedPostId: number | null = null;
  selectedCategoryId: number | null = null;
  filterOptions = ['All','userId', 'postId', 'categoryId'];
  selectedFilters: string[] = [];
  filterValues: { [key: string]: number | null } = {};
  filterValue: number | null = null;

  constructor(private postService: PostService,private userService: UserService,private commentService: CommentService,
    private categoryService: CategoryService,private router: Router,private route: ActivatedRoute) { }


 ngOnInit(): void {
     this.posts = this.postService.getPosts();
     this.users = this.userService.getUsers();
     this.comments = this.commentService.getComments();
     this.categories = this.categoryService.getCategories();
     this.filteredPosts = this.posts; // Tüm gönderileri filtrelenecek gönderilere ata
     this.totalPages = Math.ceil(this.filteredPosts.length / this.itemsPerPage);
     this.updatePaginatedPosts();

     this.route.queryParams.subscribe((params: Params) => {
      const filters = params['filters'];
      if (filters) {
        this.selectedFilters = filters.split(',');
      }
      this.filterValue = +params['value'] || null;
      this.applyFilter();
    });

     
 }
 
 updatePaginatedPosts(): void {
  const startIndex = (this.currentPage - 1) * this.itemsPerPage;
  const endIndex = startIndex + this.itemsPerPage;
  this.paginatedPosts = this.filteredPosts.slice(startIndex, endIndex);
}

onPageChange(pageNumber: number): void {
  this.currentPage = pageNumber;
  this.applyFilter(); // Apply the filter before updating paginated posts
  this.updatePaginatedPosts();
}

 getUserName(userId: number | null): string {
  if (userId === null) {
    return ''; // userId null ise boş döndür
  }
  const user = this.users.find(u => u.user_id === userId);
  return user ? user.username : '';
}

getCategory(postId: number | null): string {
  if (postId === null) {
    return '';
  }
  const post = this.posts.find(p => p.post_id === postId);
  if (!post) {
    return '';
  }
  const category = this.categories.find(c => c.category_id === post.category_id);
  return category ? category.name : '';
}

getComment(userId: number | null): string[] {
  if (userId === null) {
    return [];
  }
  const userComments = this.comments.filter(comment => comment.user_id === userId);
  return userComments.map(comment => comment.comment);
}


showDetails(userId: number, postId: number): void {
  this.router.navigate(['/post-detail', postId], { queryParams: { userId: userId } });
}

filterPosts(filterOptions: string[]): void {
  this.selectedFilters = filterOptions;
  this.filterValue = null;
  this.applyFilter();
}

applyFilter(): void {
  let tempFilteredPosts = this.posts;
  const queryParams: { [key: string]: number | null } = {};

  // Apply userId filter
  const userIdFilter = this.filterValues['userId'];
  if (userIdFilter !== null && userIdFilter !== undefined) {
    tempFilteredPosts = tempFilteredPosts.filter((post) => post.user_id === userIdFilter);
    queryParams['userId'] = userIdFilter;
  }

  // Apply postId filter
  const postIdFilter = this.filterValues['postId'];
  if (postIdFilter !== null && postIdFilter !== undefined) {
    tempFilteredPosts = tempFilteredPosts.filter((post) => post.post_id === postIdFilter);
    queryParams['postId'] = postIdFilter;
  }

  // Apply categoryId filter
  const categoryIdFilter = this.filterValues['categoryId'];
  if (categoryIdFilter !== null && categoryIdFilter !== undefined) {
    tempFilteredPosts = tempFilteredPosts.filter((post) => post.category_id === categoryIdFilter);
    queryParams['categoryId'] = categoryIdFilter;
  }

  this.filteredPosts = tempFilteredPosts;

  // Check if "All" is selected
  const allSelected = this.selectedFilters.includes('All');
  if (allSelected) {
    this.filteredPosts = this.posts;
    this.filterValues = {};
    queryParams['userId'] = null;
    queryParams['postId'] = null;
    queryParams['categoryId'] = null;
  }

  // Add query parameters to the URL
  this.router.navigate([], {
    relativeTo: this.route,
    queryParams: queryParams,
    queryParamsHandling: 'merge'
  });

  this.updatePaginatedPosts();
}






}




 