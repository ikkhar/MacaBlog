import {Injectable} from '@angular/core';
import {Article} from '../models/article';
import {ApiHelperService} from './api-helpers.service';
import {ActivatedRoute} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {
  public articleDetails: Article;
  public article: Article[];

  public articles = Article;

  constructor(private api: ApiHelperService, private route: ActivatedRoute) {
    this.article = [];
  }

  public findAll(): Promise<any> {
    return this.api.get({endpoint: '/articles'});
  }

  public findById(id: number): Article {
    return this.articles[id];
  }

}



