import { Component, OnInit } from '@angular/core';
import {Snippet} from "../snippet";
import {SnippetService} from "../snippet.service";

@Component({
  selector: 'app-snippet-detail',
  templateUrl: './snippet-detail.component.html',
  styleUrls: ['./snippet-detail.component.css']
})
export class SnippetDetailComponent implements OnInit {
  snippets: Snippet[];

  constructor(private snippetService: SnippetService) { }

  ngOnInit(): void {
    this.snippetService.getAllSnippets().subscribe(data => {
      this.snippets = data;
    })
  }

}
