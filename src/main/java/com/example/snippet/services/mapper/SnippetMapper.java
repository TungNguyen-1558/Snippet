package com.example.snippet.services.mapper;

import com.example.snippet.model.Snippet;
import com.example.snippet.services.dto.SnippetDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SnippetMapper {
	public SnippetDTO snippetToSnippetDTO(Snippet snippet) {
		return new SnippetDTO(snippet);
	}

	public List<SnippetDTO> snippetToSnippetDTO(List<Snippet> snippets) {
		return snippets.stream().filter(Objects::nonNull).map(this::snippetToSnippetDTO).collect(Collectors.toList());
	}

	public Snippet snippetDTOToSnippet(SnippetDTO snippetDTO) {
		if(snippetDTO == null){
			return null;
		}

		Snippet snippet = new Snippet();
		snippet.setId(snippetDTO.getId());
		snippet.setSnippetName(snippetDTO.getSnippetName());
		snippet.setDescriptionName(snippetDTO.getDescriptionName());
		snippet.setDescriptionContent(snippetDTO.getDescriptionContent());
		snippet.setCode(snippetDTO.getCode());
		snippet.setCodeLanguage(snippetDTO.getCodeLanguage());
		return snippet;
	}
}
