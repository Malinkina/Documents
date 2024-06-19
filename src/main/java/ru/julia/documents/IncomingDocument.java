package ru.julia.documents;

import ru.julia.staff.Employee;

/**
 * Класс описывает входящий документ
 **/
public class IncomingDocument extends Document {
    private Employee sender;
    private Employee recipient;
    private int outgoingNumber;
    private String outgoingRegDate;

    private IncomingDocument() {
    }

    @Override
    public String toString() {
        return "Входящий № " + super.toString();
    }

    /**
     * Класс присваивает значения полям класса {@link IncomingDocument}
     */
    public static class IncomingDocumentBuilder extends DocumentBuilder<IncomingDocument, IncomingDocumentBuilder> {
        private IncomingDocument incomingDocument = new IncomingDocument();
       
        public IncomingDocumentBuilder sender(Employee sender) {
            incomingDocument.sender = sender;
            return this;
        }

        public IncomingDocumentBuilder recipient(Employee recipient) {
            incomingDocument.recipient = recipient;
            return this;
        }

        public IncomingDocumentBuilder outgoingNumber(int outgoingNumber) {
            incomingDocument.outgoingNumber = outgoingNumber;
            return this;
        }

        public IncomingDocumentBuilder outgoingRegDate(String outgoingRegDate) {
            incomingDocument.outgoingRegDate = outgoingRegDate;
            return this;
        }

        @Override
        protected IncomingDocument getDocument() {
            return incomingDocument;
        }

        @Override
        public IncomingDocument build() {
            return incomingDocument;
        }
    }
}
