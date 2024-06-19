package ru.julia.documents;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class IncomingDocument extends Document {
    private String sender;
    private String recipient;
    private int outgoingNumber;
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

        public IncomingDocumentBuilder author(String author) {
            setAuthor(author);
            return this;
        }

        public IncomingDocumentBuilder sender(String sender) {
            IncomingDocument.this.sender = sender;
            return this;
        }

        public IncomingDocumentBuilder recipient(String recipient) {
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
