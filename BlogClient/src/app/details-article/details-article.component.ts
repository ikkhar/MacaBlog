import { Component, OnInit, Input } from '@angular/core';
import { Article } from '../models/article';
import { ArticleService } from '../services/articles.service';
import { ActivatedRoute, Data, Router } from '@angular/router';


@Component({
  selector: 'app-details-article',
  templateUrl: './details-article.component.html',
  styleUrls: ['./details-article.component.css']
})
export class DetailsArticleComponent implements OnInit {

  public isloading: boolean;
  id: number;
  article: Article;


  constructor(private articleService: ArticleService, private route: ActivatedRoute, private router: Router) {}

  async ngOnInit() {

    this.isloading=true;

    const id = this.route.snapshot.params['id'];
   this.article = await this.articleService.findById(id)
   .finally (()=> this.isloading=false);

  }
}

