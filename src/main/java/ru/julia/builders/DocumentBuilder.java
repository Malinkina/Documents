package ru.julia.builders;
import ru.julia.factories.DocumentFactory;
import ru.julia.documents.Document;

 public class DocumentBuilder {
    int id;
    String name;
    String text;
    int regNumber;
    String regDate;
    String author;
    DocumentBuilder id() {
        this.id = DocumentFactory.generateId();
        return this;
    }

    DocumentBuilder name() {
        this.name = DocumentFactory.generateName();
        return this;
    }

    DocumentBuilder text() {
        this.text = DocumentFactory.generateText();
        return this;
    }

    DocumentBuilder regNumber() {
        this.regNumber = DocumentFactory.generateRegNumber();
        return this;
    }

    DocumentBuilder regDate() {
        this.regDate = DocumentFactory.generateRegDate();
        return this;
    }

    DocumentBuilder author() {
        this.author = DocumentFactory.generateAuthor();
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
