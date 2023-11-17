package ru.julia.domain;

import java.time.LocalDate;

public class Document {
    private String id;
    private int doc_id;
    private String name;
    private String text;
    private String regNumber;
    private LocalDate regDate;
    private String author_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(int doc_id) {
        this.doc_id = doc_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", doc_id=" + doc_id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", regDate=" + regDate +
                ", author_id='" + author_id + '\'' +
                '}';
    }
}
