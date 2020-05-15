import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {RouterModule, Routes} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { BlogListComponent } from './blog-list/blog-list.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {BlogComponent} from './blog/blog.component';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {FlexLayoutModule} from '@angular/flex-layout';
import { BlogEntryComponent } from './blog/blog-entry/blog-entry.component';
import { ShareComponent } from './blog/share/share.component';
import { LastEntriesComponent } from './blog/last-entries/last-entries.component';








const blogRoutes: Routes = [
{ path: 'home', component: HomeComponent },
{ path: 'blog', component: BlogComponent },
{ path: '', redirectTo: 'home', pathMatch: 'full' },
{ path: '**', redirectTo: 'home' }
];

@NgModule({
  declarations: [
    AppComponent,
    BlogListComponent,
    HomeComponent,
    BlogComponent,
    BlogEntryComponent,
    ShareComponent,
    LastEntriesComponent,


  ],
  imports: [
    BrowserModule,
    MatCardModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatIconModule,
    HttpClientModule,
    RouterModule.forRoot(blogRoutes),
    MatProgressBarModule,
    FlexLayoutModule,


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
