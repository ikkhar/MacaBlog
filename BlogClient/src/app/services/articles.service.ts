import { Injectable } from '@angular/core';
import { Article } from '../models/article';
import { ApiHelperService } from './api-helpers.service';
import { ActivatedRoute } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {
  public articles: Article[];
  clickShowMore: number;

  constructor(private api: ApiHelperService, private route: ActivatedRoute) {
    this.articles = [];
    this.clickShowMore=this.clickShowMore*10 ;
  }

  public findAll(): Promise<any> {
    return this.api.get({ endpoint: '/articles' });
  }

  public findById(id: number): Promise<any> {
    return this.api.get({ endpoint: `/articles/${id}` })
  }

  public findAllByOrderByIdDesc(): Promise<any> {
    return this.api.get({ endpoint: '/articles/getLastTenArticles' });
  }
  //clickShowMore=this.clickShowMore+10;
  // requette pour charger 10 articles à chaque clique:
  public getTenArticlesByClick(clickShowMore:number): Promise<any> {
    let promise = new Promise((resolve, reject) => {
      this.clickShowMore=this.clickShowMore+1;
        this.api.get({endpoint: '/articles/getTenArticlesByClick', queryParams: { clickShowMore: 1 } })
            .then(
                res => {
                    resolve(res);
                },
                msg => {
                    reject(msg);
                }
            ).catch((error) => {
            });
    });
    return promise;
}
​
 /* public getTenArticlesByClick(clickShowMore: number): Promise<any> {
    
    let promise = new Promise((resolve, reject) => {
  this.api.get({ endpoint: '/articles/getTenArticlesByClick', queryParams: { clickShowMore } })
    .then(
      res => {
          resolve(res);
      },
      msg => {
          reject(msg);
      }
  ).catch((error) => {
  });
});
return promise;
  
  }*/


}


