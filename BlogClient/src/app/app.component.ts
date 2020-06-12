import { Component, HostListener } from '@angular/core';
import { Router } from '@angular/router';
import { ArticleService } from './services/articles.service';
import { ApiHelperService } from './services/api-helpers.service';
import { TopicsService } from './services/topics.service';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private router: Router, private api: ApiHelperService, private articleService: ArticleService, private topicsService: TopicsService){

  }

  isShow: boolean;
  topPosToStartShowing = 100;
  @HostListener('window:scroll')
  checkScroll() {

    const scrollPosition = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop || 0;
    console.log('[scroll]', scrollPosition);
    this.isShow = scrollPosition >= this.topPosToStartShowing;
  }
  gotoTop() {
    window.scroll({
      top: 0,
      left: 0,
      behavior: 'smooth'
    });
  }
}
