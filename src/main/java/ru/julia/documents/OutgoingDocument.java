package ru.julia.documents;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OutgoingDocument extends Document {
    private String recipient;
    private String deliveryType;

    private OutgoingDocument() {
    }

    public static OutgoingDocumentBuilder newBuilder() {
        return new OutgoingDocument().new OutgoingDocumentBuilder();
    }

    public String toString() {
        return "Исходящий № " + super.getRegNumber()
                + " от " + super.getRegDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
                + ". " + super.getName();
    }

    public class OutgoingDocumentBuilder {
        private OutgoingDocumentBuilder() {
        }

        public OutgoingDocumentBuilder id(int id) {
            setId(id);
            return this;
        }

        public OutgoingDocumentBuilder name(String name) {
            setName(name);
            return this;
        }

        public OutgoingDocumentBuilder text(String text) {
            setText(text);
            return this;
        }

        public OutgoingDocumentBuilder regNumber(String regNumber) {
            setRegNumber(regNumber);
            return this;
        }

        public OutgoingDocumentBuilder regDate(LocalDate regDate) {
            setRegDate(regDate);
            return this;
        }

        public OutgoingDocumentBuilder author(String author) {
            setAuthor(author);
            return this;
        }

        public OutgoingDocumentBuilder recipient(String recipient) {
            OutgoingDocument.this.recipient = recipient;
            return this;
        }

        public OutgoingDocumentBuilder deliveryType(String deliveryType) {
            OutgoingDocument.this.deliveryType = deliveryType;
            return this;
        }

        public OutgoingDocument build() {
            return OutgoingDocument.this;
        }
    }

}
