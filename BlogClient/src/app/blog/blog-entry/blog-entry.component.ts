import { Component, OnInit, HostListener } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ArticleService } from '../../services/articles.service';
import { TopicsService } from '../../services/topics.service';
import { HighlightService } from '../../services/highlight.service';

@Component({
  selector: 'app-blog-entry',
  templateUrl: './blog-entry.component.html',
  styleUrls: ['./blog-entry.component.scss']
})
export class BlogEntryComponent implements OnInit {

  highlighted: boolean = false;
  progresValue: number;
  rangeArray: number[];


  constructor(private articleService: ArticleService, private topicsService: TopicsService, private route: ActivatedRoute, private router: Router, private highlightService: HighlightService) {
    this.progresValue = 0;
    this.rangeArray = new Array(100);
  }

  @HostListener('window:scroll', [])
  onWindowScroll() {
    // tslint:disable-next-line:one-variable-per-declaration
    const element = document.documentElement,
      body = document.body,
      scrollTop = 'scrollTop',
      scrollHeight = 'scrollHeight';
    this.progresValue =
      (element[scrollTop] || body[scrollTop]) /
      ((element[scrollHeight] || body[scrollHeight]) - element.clientHeight) * 100;
  }
  /**
   * Highlight blog post when it's ready
   */
  ngAfterViewChecked() {
     {
      this.highlightService.highlightAll();
      this.highlighted = true;
    }
  }

 ngOnInit()  {}

  isMobile (){return false;}
  isNotDesktop (){return true;}
  isNotMobile (){return true;}

}



