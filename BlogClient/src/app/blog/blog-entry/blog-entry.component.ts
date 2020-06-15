import { Component, OnInit, AfterViewChecked } from '@angular/core';
import { ActivatedRoute, Data, Router } from '@angular/router';
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


  constructor(private articleService: ArticleService, private topicsService: TopicsService, private route: ActivatedRoute, private router: Router, private highlightService: HighlightService) {
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



