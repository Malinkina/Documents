package ru.julia.documents;

import com.fasterxml.jackson.annotation.JsonFormat;
import ru.julia.staff.Employee;

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
    private Employee author;

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

    public Employee getAuthor() {
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

    public void setAuthor(Employee author) {
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
    public abstract static class DocumentBuilder <T extends Document, B extends DocumentBuilder> {

        protected abstract T getDocument();

        public B id(int id) {
            getDocument().setId(id);
            return (B) this;
        }

        public B name(String name) {
            getDocument().setName(name);
            return (B) this;
        }

        public B text(String text) {
            getDocument().setText(text);
            return (B) this;
        }

        public B regNumber(String regNumber) {
            getDocument().setRegNumber(regNumber);
            return (B) this;
        }

        public B regDate(LocalDate regDate) {
            getDocument().setRegDate(regDate);
            return (B) this;
        }

        public B author(Employee author) {
            getDocument().setAuthor(author);
            return (B) this;
        }
        public abstract T build();
    }
}

