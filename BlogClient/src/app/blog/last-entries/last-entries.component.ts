import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Data, Router } from '@angular/router';
import { ArticleService } from '../../services/articles.service';
import { Article } from '../../models/article';


@Component({
  selector: 'app-last-entries',
  templateUrl: './last-entries.component.html',
  styleUrls: ['./last-entries.component.scss']
})
export class LastEntriesComponent implements OnInit {

  id: number;

  // Faire apparaitre le spinner dans ce component
  public isloading: boolean;
  public article: Article;

  constructor(private articleService: ArticleService, private route: ActivatedRoute, private router: Router) {
   }

 async ngOnInit()  {

  this.isloading=true;


  await this.articleService.getLastTenArticles()
      .then((res) => this.article = res)
      .finally (()=> this.isloading=false);
  }

  detailsArticle(id: number){
    this.router.navigate(['articles', id])
  }

}
