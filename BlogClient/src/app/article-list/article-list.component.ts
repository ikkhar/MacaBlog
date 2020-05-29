import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Data, Router} from '@angular/router';
import {ArticleService} from '../services/articles.service';
import {Article} from '../models/article';

@Component({
  selector: 'app-article-list',
  templateUrl: './article-list.component.html',
  styleUrls: ['./article-list.component.css']
})
export class ArticleListComponent implements OnInit {
  max = 5;
  public articles: [];
  constructor(private articleService: ArticleService, private route: ActivatedRoute, private router: Router) {
  }
  ngOnInit(){
    this.articleService.findAll()
      .then((res) => this.articles = res);
  }
  showMore() {
    this.max = this.max + 5;
  }
}



