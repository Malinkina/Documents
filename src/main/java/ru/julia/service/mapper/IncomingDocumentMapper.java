package ru.julia.service.mapper;

import org.springframework.stereotype.Component;
import ru.julia.document.IncomingDocument;
import ru.julia.orm.jpamodel.IncomingDocumentJPA;
import ru.julia.service.modelforservice.IncomingDocumentModel;

@Component
public class IncomingDocumentMapper {
    public IncomingDocumentModel incomingDocumentToIncomingDocumentModel(IncomingDocument incomingDocument) {
        IncomingDocumentModel.IncomingDocumentModelBuilder builder = new IncomingDocumentModel.IncomingDocumentModelBuilder();
        return builder
                .id(incomingDocument.getId())
                .documentId(incomingDocument.getDocumentId())
                .name(incomingDocument.getName())
                .text(incomingDocument.getText())
                .regNumber(incomingDocument.getRegNumber())
                .regDate(incomingDocument.getRegDate())
                .author(incomingDocument.getAuthor())
                .senderId(incomingDocument.getSender().getId())
                .recipientId(incomingDocument.getRecipient().getId())
                .outgoingNumber(incomingDocument.getOutgoingNumber())
                .outgoingRegDate(incomingDocument.getOutgoingRegDate())
                .build();
    }

    public IncomingDocumentJPA incomingDocumentModelToIncomingDocumentJpa(IncomingDocumentModel incomingDocumentModel) {
        IncomingDocumentJPA incomingDocumentJPA = new IncomingDocumentJPA();
        incomingDocumentJPA.setId(incomingDocumentModel.getId());
        incomingDocumentJPA.setDocumentId(incomingDocumentModel.getDocumentId());
        incomingDocumentJPA.setName(incomingDocumentModel.getName());
        incomingDocumentJPA.setText(incomingDocumentModel.getText());
        incomingDocumentJPA.setRegNumber(incomingDocumentModel.getRegNumber());
        incomingDocumentJPA.setRegDate(incomingDocumentModel.getRegDate());
        incomingDocumentJPA.setOutgoingNumber(incomingDocumentModel.getOutgoingNumber());
        incomingDocumentJPA.setOutgoingRegDate(incomingDocumentModel.getOutgoingRegDate());
        return incomingDocumentJPA;
    }
}
