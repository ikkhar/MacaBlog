import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { BlogComponent } from './blog/blog.component';
import { LastEntriesComponent } from './blog/last-entries/last-entries.component';
import { DetailsArticleComponent } from './details-article/details-article.component';






const blogRoutes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'blog', component: BlogComponent },
  { path: 'articles/:id', component: DetailsArticleComponent},
  { path: 'articles/:id', component: LastEntriesComponent},
  { path: 'articles/thematique/:id', component: BlogComponent},
  { path: '', redirectTo: 'home', pathMatch: 'full' },

  ];


  @NgModule({
    imports: [RouterModule.forRoot(blogRoutes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
