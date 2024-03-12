package ru.julia.mapper;

import org.springframework.stereotype.Component;
import ru.julia.document.OutgoingDocument;
import ru.julia.dto.request.OutgoingDocumentRequestDTO;
import ru.julia.dto.response.OutgoingDocumentResponseDTO;
import ru.julia.orm.jpamodel.OutgoingDocumentJPA;
import ru.julia.servicelayer.model.OutgoingDocumentModel;

@Component
public class OutgoingDocumentMapper {
    public OutgoingDocumentModel outgoingDocumentToModel(OutgoingDocument outgoingDocument) {
        OutgoingDocumentModel.OutgoingDocumentModelBuilder builder = new OutgoingDocumentModel.OutgoingDocumentModelBuilder();
        return builder
                .id(outgoingDocument.getId())
                .name(outgoingDocument.getName())
                .text(outgoingDocument.getText())
                .regNumber(outgoingDocument.getRegNumber())
                .regDate(outgoingDocument.getRegDate())
                .authorId(outgoingDocument.getAuthor().getId())
                .recipient(outgoingDocument.getRecipient().getId())
                .deliveryType(outgoingDocument.getDeliveryType())
                .build();
    }

    public OutgoingDocumentJPA modelToJpa(OutgoingDocumentModel outgoingDocumentModel) {
        OutgoingDocumentJPA outgoingDocumentJPA = new OutgoingDocumentJPA();
        outgoingDocumentJPA.setId(outgoingDocumentModel.getId());
        outgoingDocumentJPA.setName(outgoingDocumentModel.getName());
        outgoingDocumentJPA.setText(outgoingDocumentModel.getText());
        outgoingDocumentJPA.setRegNumber(outgoingDocumentModel.getRegNumber());
        outgoingDocumentJPA.setRegDate(outgoingDocumentModel.getRegDate());
        outgoingDocumentJPA.setDeliveryType(outgoingDocumentModel.getDeliveryType());
        return outgoingDocumentJPA;
    }

    public OutgoingDocumentResponseDTO jpaToResponseDto(OutgoingDocumentJPA outgoingDocumentJPA) {
        OutgoingDocumentResponseDTO outgoingDocumentResponseDTO = new OutgoingDocumentResponseDTO();
        outgoingDocumentResponseDTO.setName(outgoingDocumentJPA.getName());
        outgoingDocumentResponseDTO.setText(outgoingDocumentJPA.getText());
        outgoingDocumentResponseDTO.setAuthor(outgoingDocumentJPA.getAuthor().getSurname());
        outgoingDocumentResponseDTO.setDeliveryType(outgoingDocumentJPA.getDeliveryType());
        outgoingDocumentResponseDTO.setRecipient(outgoingDocumentJPA.getRecipient().getSurname());
        return outgoingDocumentResponseDTO;
    }

    public OutgoingDocumentModel requestDtoToModel(OutgoingDocumentRequestDTO outgoingDocumentRequestDTO) {
        OutgoingDocumentModel.OutgoingDocumentModelBuilder builder = new OutgoingDocumentModel.OutgoingDocumentModelBuilder();
        return builder
                .name(outgoingDocumentRequestDTO.getName())
                .text(outgoingDocumentRequestDTO.getText())
                .authorId(outgoingDocumentRequestDTO.getAuthorId())
                .deliveryType(outgoingDocumentRequestDTO.getDeliveryType())
                .recipient(outgoingDocumentRequestDTO.getRecipientId())
                .build();
    }
}
