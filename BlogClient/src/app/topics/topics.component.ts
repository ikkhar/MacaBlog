import { Component, OnInit } from '@angular/core';
import { MatListModule } from '@angular/material';

@Component({
  selector: 'app-topics',
  templateUrl: './topics.component.html',
  styleUrls: ['./topics.component.css']
})
export class TopicsComponent implements OnInit, MatListModule{

  topics=['topic1',' topic2', 'topic3']

  constructor() { }

  ngOnInit() {
  }

}
