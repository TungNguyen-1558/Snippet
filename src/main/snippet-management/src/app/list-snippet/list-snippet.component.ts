import {Component, OnInit} from '@angular/core';
import {Snippet} from "../snippet";
import {SnippetService} from "../snippet.service";

@Component({
  selector: 'app-list-snippet',
  templateUrl: './list-snippet.component.html',
  styleUrls: ['./list-snippet.component.css']
})
export class ListSnippetComponent implements OnInit {

  snippets: Snippet[];

  constructor(private snippetService: SnippetService) {
  }

  ngOnInit() {
    this.snippetService.getAllSnippets().subscribe(data => {
      this.snippets = data;
    });
  }

}
