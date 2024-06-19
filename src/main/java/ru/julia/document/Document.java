package ru.julia.document;

import ru.julia.xml.xmlmodel.EmployeeXml;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Класс-родитель для классов {@link IncomingDocument}, {@link OutgoingDocument}, {@link TaskDocument}
 * Реализует класс Comparable для сортировки документов по полям регистрационный номер и дата регистрации {@link #regNumber}, {@link #regDate}
 */
public abstract class Document implements Comparable<Document> {
    private Integer docId;
    private String name;
    private String text;
    private String regNumber;
    private LocalDate regDate;
    private EmployeeXml author;

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
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

    public EmployeeXml getAuthor() {
        return author;
    }

    protected void setAuthor(EmployeeXml author) {
        this.author = author;
    }

    @Override
    public int compareTo(Document document) {
        int regDateComparison = this.regDate.compareTo(document.getRegDate());
        return regDateComparison != 0 ?
                regDateComparison : this.regNumber.compareTo(document.getRegNumber());
    }

    @Override
    public String toString() {
        return "Document{" +
                "docId=" + docId +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", regDate=" + regDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Document document = (Document) o;

        if (!Objects.equals(docId, document.docId)) return false;
        if (!Objects.equals(name, document.name)) return false;
        if (!Objects.equals(text, document.text)) return false;
        if (!Objects.equals(regNumber, document.regNumber)) return false;
        if (!Objects.equals(regDate, document.regDate)) return false;
        return Objects.equals(author, document.author);
    }

    @Override
    public int hashCode() {
        int result = docId != null ? docId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (regNumber != null ? regNumber.hashCode() : 0);
        result = 31 * result + (regDate != null ? regDate.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }

    public abstract static class DocumentBuilder <T extends Document, B extends DocumentBuilder<?, ?>> {

        protected abstract T getDocument();
        /*public B id(int id) {
            getDocument().setDocId(id);
            return (B) this;
        }*/
        public B documentId(int id) {
            getDocument().setDocId(id);
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

        public B author(EmployeeXml author) {
            getDocument().setAuthor(author);
            return (B) this;
        }
        public abstract T build();
    }
}