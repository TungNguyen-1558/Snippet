import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListSnippetComponent } from './list-snippet.component';

describe('ListSnippetComponent', () => {
  let component: ListSnippetComponent;
  let fixture: ComponentFixture<ListSnippetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListSnippetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListSnippetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
