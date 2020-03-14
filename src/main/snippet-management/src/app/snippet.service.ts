import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Snippet} from "./snippet";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SnippetService {
  private url: string;

  constructor(private http: HttpClient) {
    this.url = '//localhost:8080/snippets';
  }

  public getAllSnippets(): Observable<Snippet[]> {
    return this.http.get<Snippet[]>(this.url);
  }
}
