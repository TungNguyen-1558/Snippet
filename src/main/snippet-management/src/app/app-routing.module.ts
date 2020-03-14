import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {ListSnippetComponent} from "./list-snippet/list-snippet.component";

const routes: Routes = [
  {path: 'snippets', component: ListSnippetComponent}
];

@NgModule({
  declarations: [],
  imports: [
    [RouterModule.forRoot(routes)],
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
