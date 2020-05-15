import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-last-entries',
  templateUrl: './last-entries.component.html',
  styleUrls: ['./last-entries.component.scss']
})
export class LastEntriesComponent implements OnInit {
  lasts = [
    {
      title: 'Blog n°0',
    },
    {
      title: 'Blog n°1',
    },
    {
      title: 'Blog n°2',
    },
    {
      title: 'Blog n°3',
    },
    {
      title: 'Blog n°4',
    },
    {
      title: 'Blog n°5',
    },
    {
      title: 'Blog n°6',
    },
    {
      title: 'Blog n°7',
    },
    {
      title: 'Blog n°8',
    },
    {
      title: 'Blog n°9',
    },
    {
      title: 'Blog n°10',
    },
    ];
  constructor() { }

  ngOnInit(): void {
  }

}
