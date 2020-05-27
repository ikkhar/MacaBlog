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
  articles = [
    {
      title: 'Article n°0',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°0'
    },
    {
      title: 'Article n°1',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°1'
    },
    {
      title: 'Article n°2',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°2'
    },
    {
      title: 'Article n°3',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°4'
    },
    {
      title: 'Article n°5',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°5'
    },
    {
      title: 'Article n°6',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°6'
    },
    {
      title: 'Article n°7',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°7'
    },

  ];

  constructor(private article: ArticleService, private route: ActivatedRoute, private router: Router) {
  }
  ngOnInit(){
    this.article.findAll()
      .then((res) => this.articles = res);
  }
  showMore() {
    this.max = this.max + 5;
  }
}



