package com.example.snippet.controller;

import com.example.snippet.model.Snippet;
import com.example.snippet.services.SnippetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SnippetController {
	private SnippetService snippetService;

	public SnippetController(SnippetService snippetService) {
		this.snippetService = snippetService;
	}

	@RequestMapping(value = "/snippets", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Snippet> getAllSnippets() {
		return snippetService.getAllSnippets();
	}

	@RequestMapping(value = "/snippets", method = RequestMethod.POST)
	public Snippet createSnippet(@Valid @RequestBody Snippet snippet) {
		return snippetService.createSnippet(snippet);
	}

	@RequestMapping(value = "/snippets/{id}", method = RequestMethod.DELETE)
	public Snippet deleteSnippet(@PathVariable("id") int id) {
		return snippetService.deleteSnippet(id);
	}

	@RequestMapping(value = "/snippets", method = RequestMethod.PUT)
	public Snippet updateSnippet(@PathVariable(value = "id") int id, @Valid @RequestBody Snippet snippetInfo) {
		return snippetService.updateSnippet(id, snippetInfo);
	}

	@RequestMapping(value = "/snippets/{id}", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public Snippet findSnippetById(@PathVariable("id") int id) {
		return snippetService.findById(id);
	}
}
