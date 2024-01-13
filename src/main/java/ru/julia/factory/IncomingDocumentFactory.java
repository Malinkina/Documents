package ru.julia.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.document.IncomingDocument;
import ru.julia.infogenerator.IncomingDocumentInfoGenerator;

/**
 * Класс создает объект класса {@link IncomingDocument}
 */
@Component
public class IncomingDocumentFactory extends AbstractDocumentFactory<IncomingDocument, IncomingDocument.IncomingDocumentBuilder> {
    @Autowired
    private IncomingDocumentInfoGenerator incomingDocumentInfoGenerator;


    @Override
    public IncomingDocument.IncomingDocumentBuilder createBuilder() {
        return new IncomingDocument.IncomingDocumentBuilder();
    }

    @Override
    public void fill(IncomingDocument.IncomingDocumentBuilder builder) {
        builder
                .sender(incomingDocumentInfoGenerator.generateSender())
                .recipient(incomingDocumentInfoGenerator.generateRecipient())
                .outgoingNumber(incomingDocumentInfoGenerator.generateOutgoingNumber())
                .outgoingRegDate(incomingDocumentInfoGenerator.generateRegDate());
    }
}