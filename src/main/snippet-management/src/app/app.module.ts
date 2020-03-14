import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { ListSnippetComponent } from './list-snippet/list-snippet.component';
import { SnippetDetailComponent } from './snippet-detail/snippet-detail.component';
import { HttpClientModule } from "@angular/common/http";
import {SnippetService} from "./snippet.service";
import { AppRoutingModule } from './app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ListSnippetComponent,
    SnippetDetailComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [SnippetService],
  bootstrap: [AppComponent]
})
export class AppModule { }
