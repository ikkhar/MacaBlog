import { Injectable } from '@angular/core';
import {Blog} from '../models/blog';
import {ApiHelperService} from './api-helpers.service';

@Injectable({
  providedIn: 'root'
})
export class BlogService {
  public blogs = Blog;
  constructor(private api: ApiHelperService) { }
  // Import depuis le Backend
  public findAll(): Promise<any> {
    let promise = new Promise((resolve, reject) => {
      this.api.get({ endpoint: '', queryParams: {  } })
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
