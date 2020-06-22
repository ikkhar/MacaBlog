import { Component, OnInit, AfterViewChecked } from '@angular/core';
import { ActivatedRoute, Data, Router } from '@angular/router';
import { ArticleService } from '../services/articles.service';
import { TopicsService } from '../services/topics.service';
import { HighlightService } from '../services/highlight.service';
import { Topic } from 'src/app/models/topic';
import { Article } from 'src/app/models/article';

@Component({
  selector: 'app-details-topic',
  templateUrl: './details-topic.component.html',
  styleUrls: ['./details-topic.component.css']
})
export class DetailsTopicComponent implements OnInit, AfterViewChecked {

  public isloading: boolean;
  id: number;
  name: string;
  public article: Article;
  public topic: Topic;
  max=10;
  public clickShowMore: number = 0
  highlighted: boolean = false;



  constructor(private articleService: ArticleService, private topicsService: TopicsService, private route: ActivatedRoute, private router: Router, private highlightService: HighlightService) {
    
    this.clickShowMore = 0; // Je le met à 0 je sais pas si c'est une bonne idée ou pas
    
  }
  /**
   * Highlight blog post when it's ready
   */
  ngAfterViewChecked() {
     {
      this.highlightService.highlightAll();
      this.highlighted = true;
    }
  }

 async ngOnInit()  {


  const id = this.route.snapshot.params['id'];
  this.topic = await this.topicsService.findById(id);
  
 }

  detailsArticle(id: number){
    this.router.navigate(['articles', id])
  }

  getAllArticlesByThematiqueByClick(): Promise<any> {
    const {id} = this.route.snapshot.params
    return this.topicsService.getTenArticlesByThematiqueByClick(this.topic.id,this.clickShowMore).then(res => {
      this.article = res;
      console.log(this.topic);
      this.clickShowMore += 1;
    });
  }



  showMore() {
    this.max = this.max + 10;
  }

}




