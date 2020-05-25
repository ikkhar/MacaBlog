import {Injectable} from '@angular/core';
import {Blog} from '../models/blog';
import {ApiHelperService} from './api-helpers.service';
import {ActivatedRoute} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class BlogService {
  public blogDetails: Blog;
  public blog: Blog[];

  public blogs = Blog;

  constructor(private api: ApiHelperService, private route: ActivatedRoute) {
    this.blog = [];
  }

  public findAll(): Promise<any> {
    return this.api.get({endpoint: '/articles'});
  }
}



