package ru.julia.document;

import ru.julia.xml.xmlmodel.EmployeeXML;

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
    private LocalDate regDate;
    private EmployeeXML author;

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    protected void setText(String text) {
        this.text = text;
    }

    public String getRegNumber() {
        return regNumber;
    }

    protected void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    protected void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public EmployeeXML getAuthor() {
        return author;
    }

    protected void setAuthor(EmployeeXML author) {
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
    public abstract static class DocumentBuilder <T extends Document, B extends DocumentBuilder<?, ?>> {

        protected abstract T getDocument();
        public B id(int id) {
            getDocument().setId(id);
            return (B) this;
        }
        public B documentId(int id) {
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

        public B author(EmployeeXML author) {
            getDocument().setAuthor(author);
            return (B) this;
        }
        public abstract T build();
    }
}