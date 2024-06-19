package ru.julia.documents;

import java.time.LocalDate;

public abstract class Document implements Comparable<Document> {
    private int id;
    private String name;
    private String text;
    private String regNumber;
    private LocalDate regDate;
    private String author;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int compareTo(Document document) {
        int regDateComparison = this.regDate.compareTo(document.getRegDate());
        return regDateComparison != 0 ?
                regDateComparison : this.regNumber.compareTo(document.getRegNumber());
    }


    /*public static class DocumentBuilder {

        public DocumentBuilder setId(int id) {
            document.id = id;
            return this;
        }

        public DocumentBuilder setName(String name) {
            document.name = name;
            return this;
        }

        public DocumentBuilder setText(String text) {
            document.text = text;
            return this;
        }

        public DocumentBuilder setRegNumber(int regNumber) {
            document.regNumber = regNumber;
            return this;
        }

        public DocumentBuilder setRegDate(String regDate) {
            document.regDate = regDate;
            return this;
        }

        public DocumentBuilder setAuthor(String author) {
            document.author = author;
            return this;
        }
        public Document build() {
            return document;
        }
    }*/
}

