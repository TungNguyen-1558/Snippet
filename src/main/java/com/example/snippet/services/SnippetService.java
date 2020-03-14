package com.example.snippet.services;

import com.example.snippet.model.Snippet;
import com.example.snippet.repository.SnippetRepository;
import com.example.snippet.services.dto.SnippetDTO;
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

	public List<Snippet> getAllSnippets() {
		List<Snippet> listSnippet = snippetRepository.findAll();
		if(listSnippet.isEmpty()) {
			return null;
		}
		return listSnippet;
	}

	public Snippet createSnippet(@Valid @RequestBody SnippetDTO snippetDTO) {
		Snippet snippet = new Snippet();
		snippet.setSnippetName(snippetDTO.getSnippetName());
		snippet.setDescriptionName(snippetDTO.getDescriptionName());
		snippet.setDescriptionContent(snippetDTO.getDescriptionContent());
		snippet.setCode(snippetDTO.getCode());
		snippet.setCodeLanguage(snippetDTO.getCodeLanguage());
		return snippetRepository.save(snippet);
	}

	public Snippet updateSnippet(@Valid @RequestBody SnippetDTO snippetDTO) {
		Snippet snippet = snippetRepository.getOne(snippetDTO.getId());
		if(snippet == null) {
			return null;
		}

		if(snippetDTO.getSnippetName() != null) {
			snippet.setSnippetName(snippetDTO.getSnippetName());
		}

		if(snippetDTO.getDescriptionName() != null) {
			snippet.setDescriptionName(snippetDTO.getDescriptionName());
		}

		if(snippetDTO.getDescriptionContent() != null) {
			snippet.setDescriptionContent(snippetDTO.getDescriptionContent());
		}

		if(snippetDTO.getCode() != null) {
			snippet.setCode(snippetDTO.getCode());
		}

		if(snippetDTO.getCodeLanguage() != null) {
			snippet.setCodeLanguage(snippetDTO.getCodeLanguage());
		}

		snippetRepository.save(snippet);
		return snippet;
	}

	public Snippet deleteSnippet(@PathVariable(value = "id") int id) {
		Snippet snippet = snippetRepository.getOne(id);
		if(snippet == null) {
			return null;
		}
		snippetRepository.delete(snippet);
		return snippet;
	}

	public Snippet findById(@PathVariable("id") int id) {
		Snippet snippet = snippetRepository.getOne(id);
		if(snippet == null) {
			return null;
		}
		return snippet;
	}
}
