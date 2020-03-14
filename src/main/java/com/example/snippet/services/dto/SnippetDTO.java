package com.example.snippet.services.dto;

import com.example.snippet.model.Snippet;

public class SnippetDTO {
	private int id;
	private String snippetName;
	private String descriptionName;
	private String descriptionContent;
	private String code;
	private String codeLanguage;

	public SnippetDTO() { }

	public SnippetDTO(Snippet snippet) {
		this.id = snippet.getId();
		this.snippetName = snippet.getSnippetName();
		this.descriptionName = snippet.getDescriptionName();
		this.descriptionContent = snippet.getDescriptionContent();
		this.code = snippet.getCode();
		this.codeLanguage = snippet.getCodeLanguage();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSnippetName() {
		return snippetName;
	}

	public void setSnippetName(String snippetName) {
		this.snippetName = snippetName;
	}

	public String getDescriptionName() {
		return descriptionName;
	}

	public void setDescriptionName(String descriptionName) {
		this.descriptionName = descriptionName;
	}

	public String getDescriptionContent() {
		return descriptionContent;
	}

	public void setDescriptionContent(String descriptionContent) {
		this.descriptionContent = descriptionContent;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeLanguage() {
		return codeLanguage;
	}

	public void setCodeLanguage(String codeLanguage) {
		this.codeLanguage = codeLanguage;
	}
}
