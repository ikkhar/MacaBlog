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
    // this.clickShowMore=this.clickShowMore++ ; // ici il va faire "undefined + 1 " et donc ça donne NaN (not a number)
    this.clickShowMore = 0; // Je le met à 0 je sais pas si c'est une bonne idée ou pas
  }

  public findAll(): Promise<any> {
    return this.api.get({ endpoint: '/articles' });
  }
 
  public findById(id: number): Promise<any> {
    return this.api.get({ endpoint: `/articles/${id}` })
  }

  public getLastTenArticles(): Promise<any> {
    return this.api.get({endpoint: '/articles/getLastTenArticles'});
  }
 
 // requette pour charger 10 articles à chaque clique:


public getTenArticlesByClick(nbElementToShow:number): Promise<any> {
    let promise = new Promise((resolve, reject) => {
        this.api.get({endpoint: '/articles/getTenArticlesByClick', queryParams: { "clickShowMore":nbElementToShow} })
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


}


