import { Component, OnInit } from '@angular/core';
import { MatListModule } from '@angular/material';

@Component({
  selector: 'app-topics',
  templateUrl: './topics.component.html',
  styleUrls: ['./topics.component.css']
})
export class TopicsComponent implements OnInit, MatListModule {

  topics: string[] =['Angular','Bases de données', 'Conception','Développement mobile', 'HTML & CSS', 'Intégration continue', 'Java', 'Javascript', 'Linux', 'Management', '.NET', 'PHP', 'Pyton', 'Sécurité', 'XML']

  constructor() { }

  ngOnInit() {
  }

}
