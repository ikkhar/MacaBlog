import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Data, Router} from '@angular/router';
import {BlogService} from '../services/blog.service';
import {Blog} from '../models/blog';

@Component({
  selector: 'app-blog-list',
  templateUrl: './blog-list.component.html',
  styleUrls: ['./blog-list.component.css']
})
export class BlogListComponent implements OnInit {
  max = 5;
  blogs = [
    {
      title: 'Blog n°0',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°0'
    },
    {
      title: 'Blog n°1',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°1'
    },
    {
      title: 'Blog n°2',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°2'
    },
    {
      title: 'Blog n°3',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°4'
    },
    {
      title: 'Blog n°5',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°5'
    },
    {
      title: 'Blog n°6',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°6'
    },
    {
      title: 'Blog n°7',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°7'
    },
    {
      title: 'Blog n°8',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°8'
    },
    {
      title: 'Blog n°9',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°9'
    },
    {
      title: 'Blog n°10',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°10'
    },
    {
      title: 'Blog n°11',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°11'
    },
    {
      title: 'Blog n°12',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°10'
    },
    {
      title: 'Blog n°13',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°13'
    },
    {
      title: 'Blog n°14',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°14'
    },
    {
      title: 'Blog n°15',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°15'
    },
    {
      title: 'Blog n°16',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°16'
    },
    {
      title: 'Blog n°17',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°17'
    },
    {
      title: 'Blog n°18',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°18'
    },
    {
      title: 'Blog n°19',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°19'
    },
    {
      title: 'Blog n°20',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°20'
    },
    {
      title: 'Blog n°21',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°21'
    },
    {
      title: 'Blog n°22',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°22'
    },
    {
      title: 'Blog n°23',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°23'
    },
    {
      title: 'Blog n°24',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°24'
    },
    {
      title: 'Blog n°25',
      date: '12/12/19',
      description: 'Ceci est la description du blog n°25'
    },
  ];

  constructor(private blog: BlogService, private route: ActivatedRoute, private router: Router) {
  }
  ngOnInit(){
    this.blog.findAll()
      .then((res) => this.blogs = res);
  }
  showMore() {
    this.max = this.max + 5;
  }
}



