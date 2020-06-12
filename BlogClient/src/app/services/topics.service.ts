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

constructor(private api: ApiHelperService, private route: ActivatedRoute, private articleService: ArticleService) {
  this.topic = [];
 }

 public findAll(): Promise<any> {
  return this.api.get({endpoint: '/articles/thematiques'});
}

public findById(id: number): Promise<any> {
  return this.api.get({endpoint: `/articles/thematique/${id}`})
}

public findByName(name: string): Promise<any> {
  return this.api.get({endpoint: `/articles/thematique/${name}`})
}

}
