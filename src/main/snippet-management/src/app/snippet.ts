export class Snippet {
  id: number;
  snippetName: string;
  descriptionName: string;
  descriptionContent: string;
  code: string;
  codeLanguage: string;

  constructor(id: number, snippetName: string, descriptionName: string, descriptionContent: string, code: string, codeLanguage: string) {
    this.id = id;
    this.snippetName = snippetName;
    this.descriptionName = descriptionName;
    this.descriptionContent = descriptionContent;
    this.code = code;
    this.codeLanguage = codeLanguage;
  }
}
