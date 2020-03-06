package com.example.snippet.services;

import com.example.snippet.model.Snippet;
import com.example.snippet.repository.SnippetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Service
public class SnippetService {
	@Autowired
	private SnippetRepository snippetRepository;

	public ResponseEntity<List<Snippet>> getAllSnippets() {
		List<Snippet> listSnippet = snippetRepository.findAll();
		if(listSnippet.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(listSnippet, HttpStatus.OK);
	}

	public Snippet createSnippet(@Valid @RequestBody Snippet snippet) {
		return snippetRepository.save(snippet);
	}

	public ResponseEntity<Snippet> updateSnippet(@PathVariable(value = "id") int id, @Valid @RequestBody Snippet snippetInfo) {
		Snippet snippet = snippetRepository.getOne(id);
		if(snippet == null) {
			return ResponseEntity.notFound().build();
		}
		snippet.setSnippetName(snippetInfo.getSnippetName());
		snippet.setDescriptionName(snippetInfo.getDescriptionName());
		snippet.setDescriptionContent(snippetInfo.getDescriptionContent());
		snippet.setCode(snippetInfo.getCode());
		snippet.setCodeLanguage(snippetInfo.getCodeLanguage());

		Snippet updatedSnippet = snippetRepository.save(snippet);
		return ResponseEntity.ok(updatedSnippet);
	}

	public ResponseEntity<Snippet> deleteSnippet(@PathVariable(value = "id") int id) {
		Snippet snippet = snippetRepository.getOne(id);
		if(snippet == null) {
			return ResponseEntity.notFound().build();
		}
		snippetRepository.delete(snippet);
		return ResponseEntity.ok().build();
	}

	public Snippet findById(@PathVariable("id") int id) {
		Snippet snippet = snippetRepository.getOne(id);
		if(snippet == null) {
			ResponseEntity.notFound().build();
		}
		return snippet;
	}
}
