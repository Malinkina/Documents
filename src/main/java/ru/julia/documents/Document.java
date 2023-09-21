package ru.julia.documents;

import com.fasterxml.jackson.annotation.JsonFormat;
import ru.julia.staff.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Класс-родитель для классов {@link IncomingDocument}, {@link OutgoingDocument}, {@link TaskDocument}
 * Реализует класс Comparable для сортировки документов по полям регистрационный номер и дата регистрации {@link #regNumber}, {@link #regDate}
 */
public abstract class Document implements Comparable<Document> {
    private int id;
    private String name;
    private String text;
    private String regNumber;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate regDate;
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

    public String toString() {
        return getRegNumber()
                + " от " + getRegDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
                + ". " + getName();
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

