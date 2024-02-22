package ru.julia.document;

import ru.julia.xml.xmlmodel.XMLEmployee;

/**
 * Класс описывает входящий документ
 **/
public class IncomingDocument extends Document {
    private XMLEmployee sender;
    private XMLEmployee recipient;
    private int outgoingNumber;
    private String outgoingRegDate;

    private IncomingDocument() {
    }

    public XMLEmployee getSender() {
        return sender;
    }

    public XMLEmployee getRecipient() {
        return recipient;
    }

    public int getOutgoingNumber() {
        return outgoingNumber;
    }

    public String getOutgoingRegDate() {
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
       
        public IncomingDocumentBuilder sender(XMLEmployee sender) {
            incomingDocument.sender = sender;
            return this;
        }

        public IncomingDocumentBuilder recipient(XMLEmployee recipient) {
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