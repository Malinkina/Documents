package ru.julia.document;

import lombok.Data;
import ru.julia.xml.xmlmodel.EmployeeXml;

import java.time.LocalDate;

/**
 * Класс-родитель для классов {@link IncomingDocument}, {@link OutgoingDocument}, {@link TaskDocument}
 * Реализует класс Comparable для сортировки документов по полям регистрационный номер и дата регистрации {@link #regNumber}, {@link #regDate}
 */

@Data
public abstract class Document implements Comparable<Document> {
    private Integer docId;
    private String name;
    private String text;
    private String regNumber;
    private LocalDate regDate;
    private EmployeeXml author;

    @Override
    public int compareTo(Document document) {
        int regDateComparison = this.regDate.compareTo(document.getRegDate());
        return regDateComparison != 0 ?
                regDateComparison : this.regNumber.compareTo(document.getRegNumber());
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