package ru.julia.service.modelforservice;

import ru.julia.xml.xmlmodel.EmployeeXML;

import java.time.LocalDate;

public abstract class DocumentModel {
    private int id;
    private String name;
    private String text;
    private String regNumber;
    private LocalDate regDate;
    private EmployeeXML author;

    public int getId() {
        return id;
    }

    public void setId(int documentId) {
        this.id = documentId;
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

    public EmployeeXML getAuthor() {
        return author;
    }

    public void setAuthor(EmployeeXML author) {
        this.author = author;
    }
    public abstract static class DocumentModelBuilder <T extends DocumentModel, B extends DocumentModelBuilder> {
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

        public B author(EmployeeXML author) {
            getDocument().setAuthor(author);
            return (B) this;
        }
        public abstract T build();
    }
}
