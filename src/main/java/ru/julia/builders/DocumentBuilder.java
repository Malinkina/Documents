package ru.julia.builders;

import ru.julia.documents.Document;
import ru.julia.infogenerators.DocumentInfoGenerator;

public class DocumentBuilder {
    int id;
    String name;
    String text;
    int regNumber;
    String regDate;
    String author;
    private DocumentBuilder id() {
        this.id = DocumentInfoGenerator.generateId();
        return this;
    }

    private DocumentBuilder name() {
        this.name = DocumentInfoGenerator.generateName();
        return this;
    }

    private DocumentBuilder text() {
        this.text = DocumentInfoGenerator.generateText();
        return this;
    }

    private DocumentBuilder regNumber() {
        this.regNumber = DocumentInfoGenerator.generateRegNumber();
        return this;
    }

    private DocumentBuilder regDate() {
        this.regDate = DocumentInfoGenerator.generateRegDate();
        return this;
    }

    private DocumentBuilder author() {
        this.author = DocumentInfoGenerator.generateAuthor();
        return this;
    }

     public void build(Document document) {
        id().name().text().regNumber().regDate().author();
        document.setId(this.id);
        document.setName(this.name);
        document.setText(this.text);
        document.setRegNumber(this.regNumber);
        document.setRegDate(this.regDate);
        document.setAuthor(this.author);
     }
}
