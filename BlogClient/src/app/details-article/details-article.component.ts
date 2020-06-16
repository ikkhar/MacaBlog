import { Component, OnInit, Input } from '@angular/core';
import { Article } from '../models/article';
import { ArticleService } from '../services/articles.service';
import { ActivatedRoute, Data, Router } from '@angular/router';
import { HighlightService } from '../services/highlight.service'


@Component({
  selector: 'app-details-article',
  templateUrl: './details-article.component.html',
  styleUrls: ['./details-article.component.css']
})
export class DetailsArticleComponent implements OnInit {

  public isloading: boolean;
  id: number;
  article: Article;

  highlighted: boolean = false;

  constructor(private articleService: ArticleService, private route: ActivatedRoute, private router: Router, private highlightService: HighlightService) {}

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

