package com.example.snippet.controller;

import com.example.snippet.model.Snippet;
import com.example.snippet.services.SnippetService;
import com.example.snippet.services.dto.SnippetDTO;
import com.example.snippet.services.mapper.SnippetMapper;
import org.springframework.http.HttpStatus;
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
	public ResponseEntity<List<SnippetDTO>> getAllSnippets() {
		List<Snippet> snippets = snippetService.getAllSnippets();
		return new ResponseEntity<>(new SnippetMapper().snippetToSnippetDTO(snippets), HttpStatus.OK);
	}

	@RequestMapping(value = "/snippets", method = RequestMethod.POST)
	public ResponseEntity<Snippet> createSnippet(@Valid @RequestBody SnippetDTO snippetDTO) {
		Snippet snippet = snippetService.createSnippet(snippetDTO);
		return new ResponseEntity<Snippet>(snippet, HttpStatus.OK);
	}

	@RequestMapping(value = "/snippets/{id}", method = RequestMethod.DELETE)
	public Snippet deleteSnippet(@PathVariable("id") int id) {
		return snippetService.deleteSnippet(id);
	}

	@RequestMapping(value = "/snippets", method = RequestMethod.PUT)
	public ResponseEntity<Snippet> updateSnippet(@Valid @RequestBody SnippetDTO snippetInfoDTO) {
		Snippet snippet = snippetService.updateSnippet(snippetInfoDTO);
		return new ResponseEntity<Snippet>(snippet, HttpStatus.OK);
	}

	@RequestMapping(value = "/snippets/{id}", method = RequestMethod.GET)
	public Snippet findSnippetById(@PathVariable("id") int id) {
		return snippetService.findById(id);
	}
}
