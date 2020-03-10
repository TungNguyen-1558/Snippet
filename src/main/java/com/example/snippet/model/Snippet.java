package com.example.snippet.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "snippetinfo")
public class Snippet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, name = "id")
	private int id;

	@Size(max = 50)
	@Column(nullable = false, name = "snippetname")
	private String snippetName;

	@Size(max = 50)
	@Column(name = "descriptionname")
	private String descriptionName;

	@Size(max = 50)
	@Column(name = "descriptioncontent")
	private String descriptionContent;

	@Size(max = 50)
	@Column(name = "code")
	private String code;

	@Size(max = 50)
	@Column(name = "codelanguage")
	private String codeLanguage;

	public Snippet() {
		id = 0;
	}

	public Snippet(int id, String snippetName, String descriptionName, String descriptionContent, String code, String codeLanguage) {
		this.id = id;
		this.snippetName = snippetName;
		this.descriptionName = descriptionName;
		this.descriptionContent = descriptionContent;
		this.code = code;
		this.codeLanguage = codeLanguage;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Snippet)) return false;
		Snippet snippet = (Snippet) o;
		return id == snippet.id &&
				snippetName.equals(snippet.snippetName) &&
				descriptionName.equals(snippet.descriptionName) &&
				descriptionContent.equals(snippet.descriptionContent) &&
				code.equals(snippet.code) &&
				codeLanguage.equals(snippet.codeLanguage);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, snippetName, descriptionName, descriptionContent, code, codeLanguage);
	}

	@Override
	public String toString() {
		return "Snippet{" +
				"id=" + id +
				", snippetName='" + snippetName + '\'' +
				", descriptionName='" + descriptionName + '\'' +
				", descriptionContent='" + descriptionContent + '\'' +
				", code='" + code + '\'' +
				", codeLanguage='" + codeLanguage + '\'' +
				'}';
	}
}
