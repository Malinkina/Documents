package ru.julia.service.mapper;

import org.springframework.stereotype.Component;
import ru.julia.document.OutgoingDocument;
import ru.julia.orm.jpamodel.OutgoingDocumentJPA;
import ru.julia.service.modelforservice.OutgoingDocumentModel;

import java.util.UUID;

@Component
public class OutgoingDocumentMapper {
    public OutgoingDocumentModel outgoingDocumentToOutgoingDocumentModel(OutgoingDocument outgoingDocument) {
        OutgoingDocumentModel outgoingDocumentModel = new OutgoingDocumentModel();
        outgoingDocumentModel.setId(UUID.randomUUID());
        outgoingDocumentModel.setRecipientId(outgoingDocument.getRecipient().getId());
        outgoingDocumentModel.setDeliveryType(outgoingDocument.getDeliveryType());
        outgoingDocumentModel.setDocumentId(outgoingDocument.getId());
        return outgoingDocumentModel;
    }
    public OutgoingDocumentJPA outgoingDocumentModelToOutgoingDocumentJpa(OutgoingDocumentModel outgoingDocumentModel) {
        OutgoingDocumentJPA outgoingDocumentJPA = new OutgoingDocumentJPA();
        outgoingDocumentJPA.setId(outgoingDocumentModel.getId());
        outgoingDocumentJPA.setDeliveryType(outgoingDocumentModel.getDeliveryType());
        return outgoingDocumentJPA;
    }
}
