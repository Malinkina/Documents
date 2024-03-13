package ru.julia.mapper;

import org.springframework.stereotype.Component;
import ru.julia.document.OutgoingDocument;
import ru.julia.dto.request.OutgoingDocRequestDto;
import ru.julia.dto.response.OutgoingDocResponseDto;
import ru.julia.orm.jpamodel.OutgoingDocJpa;
import ru.julia.servicelayer.model.OutgoingDocModel;

@Component
public class OutgoingDocumentMapper {
    public OutgoingDocModel outgoingDocumentToModel(OutgoingDocument outgoingDocument) {
        OutgoingDocModel.OutgoingDocumentModelBuilder builder = new OutgoingDocModel.OutgoingDocumentModelBuilder();
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

    public OutgoingDocJpa modelToJpa(OutgoingDocModel outgoingDocModel) {
        OutgoingDocJpa outgoingDocJPA = new OutgoingDocJpa();
        outgoingDocJPA.setId(outgoingDocModel.getId());
        outgoingDocJPA.setName(outgoingDocModel.getName());
        outgoingDocJPA.setText(outgoingDocModel.getText());
        outgoingDocJPA.setRegNumber(outgoingDocModel.getRegNumber());
        outgoingDocJPA.setRegDate(outgoingDocModel.getRegDate());
        outgoingDocJPA.setDeliveryType(outgoingDocModel.getDeliveryType());
        return outgoingDocJPA;
    }

    public OutgoingDocResponseDto jpaToResponseDto(OutgoingDocJpa outgoingDocJPA) {
        OutgoingDocResponseDto outgoingDocResponseDTO = new OutgoingDocResponseDto();
        outgoingDocResponseDTO.setName(outgoingDocJPA.getName());
        outgoingDocResponseDTO.setText(outgoingDocJPA.getText());
        outgoingDocResponseDTO.setAuthor(outgoingDocJPA.getAuthor().getSurname());
        outgoingDocResponseDTO.setDeliveryType(outgoingDocJPA.getDeliveryType());
        outgoingDocResponseDTO.setRecipient(outgoingDocJPA.getRecipient().getSurname());
        return outgoingDocResponseDTO;
    }

    public OutgoingDocModel requestDtoToModel(OutgoingDocRequestDto outgoingDocRequestDTO) {
        OutgoingDocModel.OutgoingDocumentModelBuilder builder = new OutgoingDocModel.OutgoingDocumentModelBuilder();
        return builder
                .name(outgoingDocRequestDTO.getName())
                .text(outgoingDocRequestDTO.getText())
                .authorId(outgoingDocRequestDTO.getAuthorId())
                .deliveryType(outgoingDocRequestDTO.getDeliveryType())
                .recipient(outgoingDocRequestDTO.getRecipientId())
                .build();
    }
}
