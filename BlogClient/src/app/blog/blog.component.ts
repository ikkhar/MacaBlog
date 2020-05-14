import {Component, HostListener, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';



@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.scss']
})
export class BlogComponent implements OnInit {

  progresValue: number;
  rangeArray: number[];
  constructor(private route: ActivatedRoute, private router: Router) {
    this.progresValue = 0;
    this.rangeArray = new Array(100);
  }

  @HostListener('window:scroll', [])
  onWindowScroll() {
    // tslint:disable-next-line:one-variable-per-declaration
    const element = document.documentElement,
      body = document.body,
      scrollTop = 'scrollTop',
      scrollHeight = 'scrollHeight';
    this.progresValue =
      (element[scrollTop] || body[scrollTop]) /
      ((element[scrollHeight] || body[scrollHeight]) - element.clientHeight) * 100;
  }

  ngOnInit() {
  }

}
