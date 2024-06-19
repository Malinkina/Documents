package ru.julia.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.document.IncomingDocument;
import ru.julia.infogenerator.IncomingDocInfoGenerator;

/**
 * Класс создает объект класса {@link IncomingDocument}
 */
@Component
public class IncomingDocumentFactory extends AbstractDocumentFactory<IncomingDocument, IncomingDocument.IncomingDocumentBuilder> {
    @Autowired
    private IncomingDocInfoGenerator incomingDocInfoGenerator;


    @Override
    public IncomingDocument.IncomingDocumentBuilder createBuilder() {
        return new IncomingDocument.IncomingDocumentBuilder();
    }

    @Override
    public void fill(IncomingDocument.IncomingDocumentBuilder builder) {
        builder
                .sender(incomingDocInfoGenerator.generateSender())
                .recipient(incomingDocInfoGenerator.generateRecipient())
                .outgoingNumber(incomingDocInfoGenerator.generateOutgoingNumber())
                .outgoingRegDate(incomingDocInfoGenerator.generateRegDate());
    }
}