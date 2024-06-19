package ru.julia.document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.julia.xml.xmlmodel.EmployeeXml;

@EqualsAndHashCode(callSuper = true)
@Data
public class OutgoingDocument extends Document {
    private EmployeeXml recipient;
    private String deliveryType;

    public static class OutgoingDocumentBuilder extends DocumentBuilder<OutgoingDocument, OutgoingDocumentBuilder> {
        private OutgoingDocument outgoingDocument = new OutgoingDocument();

        public OutgoingDocumentBuilder recipient(EmployeeXml recipient) {
            outgoingDocument.recipient = recipient;
            return this;
        }

        public OutgoingDocumentBuilder deliveryType(String deliveryType) {
            outgoingDocument.deliveryType = deliveryType;
            return this;
        }
        @Override
        protected OutgoingDocument getDocument() {
            return outgoingDocument;
        }

        @Override
        public OutgoingDocument build() {
            return outgoingDocument;
        }
    }
}