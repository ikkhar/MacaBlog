import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Data, Router } from '@angular/router';
import { ArticleService } from '../services/articles.service';
import { Article } from '../models/article';

@Component({
  selector: 'app-article-list',
  templateUrl: './article-list.component.html',
  styleUrls: ['./article-list.component.css']
})
export class ArticleListComponent implements OnInit {
    // Faire apparaitre le spinner dans ce component
    public isloading: boolean;

  max = 10;
  public articles: Article[];
  constructor(private articleService: ArticleService, private route: ActivatedRoute, private router: Router) {
  }
  async ngOnInit(){

    this.isloading=true;

    await this.articleService.findAll()
      .then((res) => this.articles = res)
      .finally (()=> this.isloading=false);
  }


  showMore() {
    this.max = this.max + 10;
  }

  detailsArticle(id: number){
    this.router.navigate(['articles', id])
  }

}



