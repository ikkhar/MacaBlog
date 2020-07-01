import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from '../app/app.routing.module';
import { MaterialModule } from '../app/module/material.module';
import { ShareIconsModule } from 'ngx-sharebuttons/icons';
import { ShareButtonsModule } from 'ngx-sharebuttons/buttons';
import { registerLocaleData } from '@angular/common';
import localeFr from '@angular/common/locales/fr';
registerLocaleData(localeFr, 'fr');
import { LOCALE_ID } from '@angular/core';

// Partie Component //
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './home/header/header.component';
import { FooterComponent } from './home/footer/footer.component';
import { ArticleListComponent } from './article-list/article-list.component';
import { DetailsArticleComponent } from './details-article/details-article.component';
import { BlogEntryComponent } from './blog/blog-entry/blog-entry.component';
import { ShareComponent } from './blog/share/share.component';
import { LastEntriesComponent } from './blog/last-entries/last-entries.component';
import { TopicsComponent } from './home/topics/topics.component';
import { TopicsPhoneComponent } from './home/topics/topics-phone/topics-phone.component';
import { DetailsTopicComponent } from './details-topic/details-topic.component';


// Partie share - modification CS //
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';



@NgModule({
   declarations: [
      AppComponent,
      ArticleListComponent,
      HomeComponent,
      BlogEntryComponent,
      ShareComponent,
      LastEntriesComponent,
      HeaderComponent,
      FooterComponent,
      TopicsComponent,
      TopicsPhoneComponent,
      DetailsArticleComponent,
      DetailsTopicComponent
   ],
   imports: [
      BrowserModule,
      AppRoutingModule,
      BrowserAnimationsModule,
      HttpClientModule,
      MaterialModule,
      ShareButtonsModule,
      ShareIconsModule,
      FontAwesomeModule,

   ],
   providers: [
      { provide: LOCALE_ID, useValue: "fr" }
   ],
   bootstrap: [
      AppComponent
   ]
})
export class AppModule { }
