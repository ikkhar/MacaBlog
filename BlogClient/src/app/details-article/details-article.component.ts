import { Component, OnInit, Input } from '@angular/core';
import { Article } from '../models/article';
import { ArticleService } from '../services/articles.service';
import { ActivatedRoute, Data, Router } from '@angular/router';
import { HighlightService } from '../services/highlight.service';
import { HostListener} from '@angular/core'


@Component({
  selector: 'app-details-article',
  templateUrl: './details-article.component.html',
  styleUrls: ['./details-article.component.css']
})
export class DetailsArticleComponent implements OnInit {

  progresValue: number;

  public isloading: boolean;
  id: number;
  article: Article;

  highlighted: boolean = false;

  constructor(private articleService: ArticleService, private route: ActivatedRoute, private router: Router, private highlightService: HighlightService) {
    this.progresValue = 0;
  }

  /** Progress bar */
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
    
    this.highlightService.highlightAll();
    this.highlighted = true;
  
}

  async ngOnInit() {

    this.isloading=true;

    const id = this.route.snapshot.params['id'];
   this.article = await this.articleService.findById(id)
   .finally (()=> this.isloading=false);

  }
}

