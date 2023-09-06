package ru.julia.documents;

import ru.julia.staff.Person;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
@XmlType (name = "incoming document")

public class IncomingDocument extends Document {
    @XmlElement
    private Person sender;
    @XmlElement
    private Person recipient;
    @XmlElement
    private int outgoingNumber;
    @XmlElement
    private String outgoingRegDate;

    private IncomingDocument() {
    }

    public static IncomingDocumentBuilder newBuilder() {
        return new IncomingDocument().new IncomingDocumentBuilder();
    }

    @Override
    public String toString() {
        return "Входящий № " + super.getRegNumber()
                + " от " + super.getRegDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
                + ". " + super.getName();
    }


    public class IncomingDocumentBuilder {
        private IncomingDocumentBuilder() {
        }

        public IncomingDocumentBuilder id(int id) {
            setId(id);
            return this;
        }

        public IncomingDocumentBuilder name(String name) {
            setName(name);
            return this;
        }

        public IncomingDocumentBuilder text(String text) {
            setText(text);
            return this;
        }

        public IncomingDocumentBuilder regNumber(String regNumber) {
            setRegNumber(regNumber);
            return this;
        }

        public IncomingDocumentBuilder regDate(LocalDate regDate) {
            setRegDate(regDate);
            return this;
        }

        public IncomingDocumentBuilder author(Person author) {
            setAuthor(author);
            return this;
        }

        public IncomingDocumentBuilder sender(Person sender) {
            IncomingDocument.this.sender = sender;
            return this;
        }

        public IncomingDocumentBuilder recipient(Person recipient) {
            IncomingDocument.this.recipient = recipient;
            return this;
        }

        public IncomingDocumentBuilder outgoingNumber(int outgoingNumber) {
            IncomingDocument.this.outgoingNumber = outgoingNumber;
            return this;
        }

        public IncomingDocumentBuilder outgoingRegDate(String outgoingRegDate) {
            IncomingDocument.this.outgoingRegDate = outgoingRegDate;
            return this;
        }

        public IncomingDocument build() {
            return IncomingDocument.this;
        }
    }
}
