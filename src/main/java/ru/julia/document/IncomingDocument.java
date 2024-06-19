package ru.julia.document;

import ru.julia.xml.xmlmodel.EmployeeXml;

import java.time.LocalDate;

/**
 * Класс описывает входящий документ
 **/
public class IncomingDocument extends Document {
    private EmployeeXml sender;
    private EmployeeXml recipient;
    private Integer outgoingNumber;
    private LocalDate outgoingRegDate;

    private IncomingDocument() {
    }

    public EmployeeXml getSender() {
        return sender;
    }

    public EmployeeXml getRecipient() {
        return recipient;
    }

    public Integer getOutgoingNumber() {
        return outgoingNumber;
    }

    public LocalDate getOutgoingRegDate() {
        return outgoingRegDate;
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
       
        public IncomingDocumentBuilder sender(EmployeeXml sender) {
            incomingDocument.sender = sender;
            return this;
        }

        public IncomingDocumentBuilder recipient(EmployeeXml recipient) {
            incomingDocument.recipient = recipient;
            return this;
        }

        public IncomingDocumentBuilder outgoingNumber(Integer outgoingNumber) {
            incomingDocument.outgoingNumber = outgoingNumber;
            return this;
        }

        public IncomingDocumentBuilder outgoingRegDate(LocalDate outgoingRegDate) {
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