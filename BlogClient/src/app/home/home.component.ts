import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ArticleService } from '../services/articles.service';
import { TopicsService } from '../services/topics.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  constructor(private route: ActivatedRoute, private router: Router, private articleService: ArticleService, private topicsService: TopicsService) { }

  ngOnInit() {
  }

  isMobile (){return false;}
  isNotDesktop (){return true;}
  isNotMobile (){return true;}
}
