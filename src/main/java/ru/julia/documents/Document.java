package ru.julia.documents;

import ru.julia.staff.Person;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
@XmlRootElement

public abstract class Document implements Comparable<Document> {
    @XmlElement
    private int id;
    @XmlElement
    private String name;
    @XmlElement
    private String text;
    @XmlElement
    private String regNumber;
    @XmlElement
    private LocalDate regDate;
    @XmlElement
    private Person author;

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

    public Person getAuthor() {
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

    public void setAuthor(Person author) {
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

