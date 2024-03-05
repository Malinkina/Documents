package ru.julia.service.mapper;

import org.springframework.stereotype.Component;
import ru.julia.document.OutgoingDocument;
import ru.julia.orm.jpamodel.OutgoingDocumentJPA;
import ru.julia.service.modelforservice.OutgoingDocumentModel;

@Component
public class OutgoingDocumentMapper {
    public OutgoingDocumentModel outgoingDocumentToOutgoingDocumentModel(OutgoingDocument outgoingDocument) {
        OutgoingDocumentModel.OutgoingDocumentModelBuilder builder = new OutgoingDocumentModel.OutgoingDocumentModelBuilder();
        return builder
                .id(outgoingDocument.getId())
                .name(outgoingDocument.getName())
                .text(outgoingDocument.getText())
                .regNumber(outgoingDocument.getRegNumber())
                .regDate(outgoingDocument.getRegDate())
                .author(outgoingDocument.getAuthor())
                .recipient(outgoingDocument.getRecipient().getId())
                .deliveryType(outgoingDocument.getDeliveryType())
                .build();
    }

    public OutgoingDocumentJPA outgoingDocumentModelToOutgoingDocumentJpa(OutgoingDocumentModel outgoingDocumentModel) {
        OutgoingDocumentJPA outgoingDocumentJPA = new OutgoingDocumentJPA();
        outgoingDocumentJPA.setId(outgoingDocumentModel.getId());
        outgoingDocumentJPA.setName(outgoingDocumentModel.getName());
        outgoingDocumentJPA.setText(outgoingDocumentModel.getText());
        outgoingDocumentJPA.setRegNumber(outgoingDocumentModel.getRegNumber());
        outgoingDocumentJPA.setRegDate(outgoingDocumentModel.getRegDate());
        outgoingDocumentJPA.setDeliveryType(outgoingDocumentModel.getDeliveryType());
        return outgoingDocumentJPA;
    }
}
