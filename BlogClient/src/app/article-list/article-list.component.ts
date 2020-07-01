import { Component, OnInit, HostListener } from '@angular/core';
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
  public articles: Article[];
  public isloading: boolean;
  public indexFrom: number = 0;
  public sizeListAllArticlesFromBack :number;
  max = 10; // c'est à cause de ce petit coquin, il limité l'affichage à 10 ! à remplacer dans html par articles.length

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

  async ngOnInit() {

    this.isloading = true;
    this.indexFrom = 0;
    // this.clickShowMore=this.clickShowMore*10 ;
    await this.getAllArticlesByClick() // On passe par notre méthode pour éviter la redondance de code
      .finally(() => this.isloading = false);


  }

  getAllArticlesByClick(): Promise<any> {

    return this.articleService.getTenArticlesByClick(this.indexFrom).then(res => {
      this.articles = res;
     // this.articles.length=res.length;
      console.log(this.articles);
      this.indexFrom =this.indexFrom+1;

    });
  }



  detailsArticle(id: number) {
    this.router.navigate(['articles', id])
  }
// Requête qui renvoie la taille de la liste des articles du back
getSizeAllArticlesListFromBack(): Promise<any> {

  return this.articleService.getsizeAllArticlesList().then(res => {
    this.sizeListAllArticlesFromBack = res;
    console.log(this.sizeListAllArticlesFromBack );

  });
}
 // Méthode pour mettre une condition sur la taille maximale qui est chargée à la taille de la liste des articles du back

conditionToHideButton(){
  //this.getAllArticlesByClick();
  //this.getSizeAllArticlesListFromBack()

  if ( this.length == this.sizeListAllArticlesFromBack  ) {
    return this.sizeListAllArticlesFromBack ;
  }

}





}



