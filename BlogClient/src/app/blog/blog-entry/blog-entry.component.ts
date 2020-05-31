import { Component, OnInit, AfterViewChecked } from '@angular/core';

import { HighlightService } from '../../services/highlight.service'

@Component({
  selector: 'app-blog-entry',
  templateUrl: './blog-entry.component.html',
  styleUrls: ['./blog-entry.component.scss']
})
export class BlogEntryComponent implements OnInit, AfterViewChecked {
  
  blogEntry: any;
  highlighted: boolean = false;

  entries = [
    {
      title: 'Article n°0',
      keywords: '#jaimepasjava',
      date: '12/12/19',}
  ];
  blogParagraph = '<span class="rose">Ceci</span> la description du blog n°0 Sed ut ' +
    /*'<strong>Est</strong> la description du blog n°0 Sed ut ' +*/
    'perspiciatis unde <span class="rose">Ceci</span> iste natus error sit voluptatem accusantium doloremque ' +
    'laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et ' +
    'quasi architecto beatae vitae dicta sunt explicabo. ' +
    '<pre><code class="language-css">p { color: red }</code></pre> ' +
    /*'<pre class="codeExemple">\n' +
    '  <code>\n' +
    '    p { color: red; }\n' +
    '    body { background-color: #eee; }\n' +
    '  </code>\n' +
    '</pre>' +*/
    'Nemo enim ipsam <span class="rose">Ceci</span> voluptatem quia voluptas sit aspernatur aut odit aut fugit, ' +
    'sed quia consequuntur magni dolores ' +
    'eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui ' +
    'dolorem ipsum quia dolor sit amet,<span class="rose">Ceci</span> consectetur, adipisci velit, sed quia non ' +
    'numquam <span class="rose">Ceci</span>eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat ' +
    'voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis ' +
    'suscipit laboriosam, nisi ' +
    'ut aliquid ex ea commodi consequatur? Quis autem vel eum ' +
    'iure reprehenderit qui in ea voluptate velit esse <span class="rose">Ceci</span>quam nihil molestiae consequatur, ' +
    'vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?Sed ut perspiciatis unde ' +
    'omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem ' +
    '<pre><code class="language-css">p { color: red; }\n' +
    '    body { background-color: #eee; }</code></pre> ' +
    /*'<pre class="codeExemple">\n  <code>\n' +
    '    p { color: red; }\n' +
    '    body { background-color: #eee; }\n' +
    '  </code>\n' +
    '</pre>' +*/
    'aperiam, eaque ipsa <span class="rose">Ceci</span> quae ab illo inventore veritatis et quasi architecto beatae vitae ' +
    'dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut ' +
    'fugit, sed quia consequuntur <span class="rose">Ceci</span> magni dolores eos qui ratione voluptatem sequi nesciunt. Neque ' +
    'porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed ' +
    'quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. ' +
    'Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut ' +
    'aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit ' +
    'esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo';
  constructor(private highlightService: HighlightService) {
  }
  /**
   * Highlight blog post when it's ready
   */
  ngAfterViewChecked() {
    if (this.blogEntry && !this.highlighted) {
      this.highlightService.highlightAll();
      this.highlighted = true;
    }
  }


  ngOnInit(): void {
    
  }

}



