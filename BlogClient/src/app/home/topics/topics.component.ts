import { Component, OnInit } from '@angular/core';
import { MatListModule } from '@angular/material/list';
import { ActivatedRoute, Data, Router, RouterLinkActive, ActivatedRouteSnapshot } from '@angular/router';
import { Topic } from 'src/app/models/topic';
import { TopicsService } from 'src/app/services/topics.service';
import { ArticleService } from 'src/app/services/articles.service';

@Component({
  selector: 'app-topics',
  templateUrl: './topics.component.html',
  styleUrls: ['./topics.component.scss']
})
export class TopicsComponent implements OnInit, MatListModule {
// debut version ts smartphone 
panelOpenState = false;
// fin verion ts smarphone


  public isloading: boolean;
  public topics: Topic[];
  clickedIndex: number = 0;
  

  constructor(private topicsService: TopicsService, private route: ActivatedRoute, private router: Router, private articlesService: ArticleService) { }

  async ngOnInit() {

    this.isloading=true;

    await this.topicsService.findAll()
    .then((res) => this.topics= res)
    .finally (()=> this.isloading=false);
  }

  detailsTopics(id: number){
    this.router.navigate(['articles/thematique', id])
    
  }

}

