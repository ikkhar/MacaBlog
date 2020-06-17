import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Data, Router } from '@angular/router';
import { ArticleService } from '../services/articles.service';
import { Article } from '../models/article';
import { MatTableDataSource } from '@angular/material/table';
@Component({
  selector: 'app-article-list',
  templateUrl: './article-list.component.html',
  styleUrls: ['./article-list.component.css']
})
export class ArticleListComponent implements OnInit {
    // Faire apparaitre le spinner dans ce component
    public articles: Article[];
    public isloading: boolean;
    clickShowMore=1;
  max = 10;
  dataSource;
  length: number;
  
  constructor(private articleService: ArticleService, private route: ActivatedRoute, private router: Router) {
    this.articles = [];
  }

  //Methode Benoit avec findAll() 
  /*async ngOnInit(){

    this.isloading=true;

    await this.articleService.findAll()
      .then((res) => this.articles = res)
      .finally (()=> this.isloading=false);
  }*/

// Methode pour charger 10 par 10 à chaque click
async ngOnInit() {

    this.isloading=true;
    //this.clickShowMore=this.clickShowMore+10;
    this.clickShowMore=this.clickShowMore*10 ;
    await this.articleService.getTenArticlesByClick(this.clickShowMore)
      .then((res) => this.articles = res)
      .finally (()=> this.isloading=false);
  }
  
  getAllArticlesByClick(clickShowMore: number) {
    this.clickShowMore=this.clickShowMore*10 ;
    this.clickShowMore=this.clickShowMore+1;
    //this.clickShowMore=this.clickShowMore+10
    this.articleService.getTenArticlesByClick(this.clickShowMore).then(res => {   
       this.articles = res;
      
    });
  }


  showMore() {
    this.clickShowMore=this.clickShowMore*10 ;
   // this.clickShowMore=this.clickShowMore+10;
   // this.max = this.max + 10;
  }

  detailsArticle(id: number){
    this.router.navigate(['articles', id])
  }

}



