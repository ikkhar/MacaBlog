import { Component, OnInit } from '@angular/core';
import { Article } from '../models/article';
import { ArticleService } from '../services/articles.service';
import { ActivatedRoute, Data, Router } from '@angular/router';
import { HighlightService } from '../services/highlight.service';
import { HostListener } from '@angular/core'
import { Auteur } from '../models/auteur';
import { Thematique } from '../models/thematique';
import { TopicsService } from '../services/topics.service';
import { Topic } from 'src/app/models/topic';


@Component({
  selector: 'app-details-article',
  templateUrl: './details-article.component.html',
  styleUrls: ['./details-article.component.css']
})
export class DetailsArticleComponent implements OnInit {

  progresValue: number;

  public isloading: boolean;
  id: number;
  auteurList: Auteur[];
  thematiques: Thematique[];
  public article: Article;
  public topics: Topic[];



 
  highlighted: boolean = false;


  constructor(private articleService: ArticleService, private topicsService: TopicsService, private route: ActivatedRoute, private router: Router, private highlightService: HighlightService) {
    this.progresValue = 0;
  }

  /** Progress bar */
  @HostListener('window:scroll', [])
  onWindowScroll() {
    // tslint:disable-next-line:one-variable-per-declaration
    const element = document.documentElement,
      body = document.body,
      scrollTop = 'scrollTop',
      scrollHeight = 'scrollHeight';
    this.progresValue =
      (element[scrollTop] || body[scrollTop]) /
      ((element[scrollHeight] || body[scrollHeight]) - element.clientHeight) * 100;
  }

  /**
   * Highlight blog post when it's ready
   */
  ngAfterViewChecked() {

    this.highlightService.highlightAll();
    this.highlighted = true;

}

async ngOnInit() {
  this.route.params.subscribe( async (params) =>  {
    this.isloading=true;
    const id = params.id;

    this.article = await this.articleService.findById(id)
      .finally (()=> this.isloading=false);
  })
}

  getArticlesByAuteurId(): Promise<any> {
    return this.articleService.getArticlesByAuteurId(this.id).then(res => {
      this.article = res;
      console.log(this.article);
  });
}

detailsTopics(id: number){
  this.router.navigate(['articles/thematique', id])

}

}
