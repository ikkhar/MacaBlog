import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LastEntriesComponent } from './blog/last-entries/last-entries.component';
import { DetailsArticleComponent } from './details-article/details-article.component';
import { BlogEntryComponent } from './blog/blog-entry/blog-entry.component';



const blogRoutes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'articles/:id', component: DetailsArticleComponent},
  { path: 'articles/:id', component: LastEntriesComponent},
  { path: 'articles/thematique/:id', component: BlogEntryComponent},
  { path: '', redirectTo: 'home', pathMatch: 'full' },

  ];


  @NgModule({
    imports: [RouterModule.forRoot(blogRoutes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
