import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-last-entries',
  templateUrl: './last-entries.component.html',
  styleUrls: ['./last-entries.component.scss']
})
export class LastEntriesComponent implements OnInit {
  lasts = [
    {
      title: 'Article n°0',
    },
    {
      title: 'Article n°1',
    },
    {
      title: 'Article n°2',
    },
    {
      title: 'Article n°3',
    },
    {
      title: 'Article n°4',
    },
    {
      title: 'Article n°5',
    },
    {
      title: 'Article n°6',
    },
    {
      title: 'Article n°7',
    },
    {
      title: 'Article n°8',
    },
    {
      title: 'Article n°9',
    },
    {
      title: 'Article n°10',
    },
    ];
  constructor() { }

  ngOnInit(): void {
  }

}
