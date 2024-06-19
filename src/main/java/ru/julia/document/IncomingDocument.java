package ru.julia.document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.julia.xml.xmlmodel.EmployeeXml;

import java.time.LocalDate;

/**
 * Класс описывает входящий документ
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class IncomingDocument extends Document {
    private EmployeeXml sender;
    private EmployeeXml recipient;
    private Integer outgoingNumber;
    private LocalDate outgoingRegDate;
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