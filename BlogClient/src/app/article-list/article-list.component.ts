import { Component, OnInit, HostListener } from '@angular/core';
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
  public clickShowMore: number = 1;
  max = 10; // c'est à cause de ce petit coquin, il limité l'affichage à 10 ! à remplacer dans html par articles.length
  dataSource;
  length: number;
  event: boolean = false;
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

  


  // Get All Rticle By click with Host Listener Event :
  async ngOnInit() {

    this.isloading = true;
    this.clickShowMore = 0;
    // this.clickShowMore=this.clickShowMore*10 ;
    await this.getAllArticlesByClick() // On passe par notre méthode pour éviter la redondance de code
      .finally(() => this.isloading = false);
  }

  getAllArticlesByClick(): Promise<any> {
    return this.articleService.getTenArticlesByClick(this.clickShowMore).then(res => {
      this.articles = res;
      console.log(this.articles);
      this.clickShowMore += 1;
    });
  }



  detailsArticle(id: number) {
    this.router.navigate(['articles', id])
  }

}



