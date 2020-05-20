import { Component, OnInit } from '@angular/core';
import {MatListModule} from '@angular/material/list';

@Component({
  selector: 'app-topics-phone',
  templateUrl: './topics-phone.component.html',
  styleUrls: ['./topics-phone.component.scss']
})
export class TopicsPhoneComponent implements OnInit, MatListModule  {
  panelOpenState = false;

  topics: string[] =['Angular','Bases de données', 'Conception','Développement mobile', 'HTML & CSS', 'Intégration continue', 'Java', 'Javascript', 'Linux', 'Management', '.NET', 'PHP', 'Pyton', 'Sécurité', 'XML']

  constructor() { }

  ngOnInit(): void{
  }
isNotDesktop(){return true;}
}
