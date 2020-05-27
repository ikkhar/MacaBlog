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
    {
      title: 'Article n°8',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°8'
    },
    {
      title: 'Article n°9',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°9'
    },
    {
      title: 'Article n°10',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°10'
    },
    {
      title: 'Article n°11',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°11'
    },
    {
      title: 'Article n°12',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°10'
    },
    {
      title: 'Article n°13',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°13'
    },
    {
      title: 'Article n°14',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°14'
    },
    {
      title: 'Article n°15',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°15'
    },
    {
      title: 'Article n°16',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°16'
    },
    {
      title: 'Article n°17',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°17'
    },
    {
      title: 'Article n°18',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°18'
    },
    {
      title: 'Article n°19',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°19'
    },
    {
      title: 'Article n°20',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°20'
    },
    {
      title: 'Article n°21',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°21'
    },
    {
      title: 'Article n°22',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°22'
    },
    {
      title: 'Article n°23',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°23'
    },
    {
      title: 'Article n°24',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°24'
    },
    {
      title: 'Article n°25',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°25'
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



