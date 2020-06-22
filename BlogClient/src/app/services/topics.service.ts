import { Injectable } from '@angular/core';
import { Topic } from '../models/topic';
import { ApiHelperService } from './api-helpers.service';
import { ActivatedRoute } from '@angular/router';
import { ArticleService } from './articles.service';


@Injectable({
  providedIn: 'root'
})
export class TopicsService {
  public topic: Topic[];
  clickShowMore: number;
constructor(private api: ApiHelperService, private route: ActivatedRoute, private articleService: ArticleService) {
  this.topic = [];
  this.clickShowMore = 0; // Je le met à 0 je sais pas si c'est une bonne idée ou pas
 }

 public findAll(): Promise<any> {
  return this.api.get({endpoint: '/articles/thematiques'});
}

public findById(id: number): Promise<any> {
  return this.api.get({endpoint: `/articles/thematique/${id}`})
}

public findByName(name: string): Promise<any> {
  return this.api.get({endpoint: `/articles/thematiques/name/${name}`})
}

// Charger du back 10 articles à chaque click
public getTenArticlesByThematiqueByClick(id: number,nbElementToShow:number): Promise<any> {
  let promise = new Promise((resolve, reject) => {
      this.api.get({endpoint: `/articles/thematique/${id}/getAllArticlesByClick`, queryParams: { "clickShowMore":nbElementToShow} })
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
