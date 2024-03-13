package ru.julia.mapper;

import org.springframework.stereotype.Component;
import ru.julia.document.IncomingDocument;
import ru.julia.dto.request.IncomingDocRequestDto;
import ru.julia.dto.response.IncomingDocResponseDto;
import ru.julia.orm.jpamodel.IncomingDocJpa;
import ru.julia.servicelayer.model.IncomingDocModel;

@Component
public class IncomingDocumentMapper {
    public IncomingDocModel incomingDocumentToModel(IncomingDocument incomingDocument) {
        IncomingDocModel.IncomingDocumentModelBuilder builder = new IncomingDocModel.IncomingDocumentModelBuilder();
        return builder
                .id(incomingDocument.getId())
                .name(incomingDocument.getName())
                .text(incomingDocument.getText())
                .regNumber(incomingDocument.getRegNumber())
                .regDate(incomingDocument.getRegDate())
                .authorId(incomingDocument.getAuthor().getId())
                .senderId(incomingDocument.getSender().getId())
                .recipientId(incomingDocument.getRecipient().getId())
                .outgoingNumber(incomingDocument.getOutgoingNumber())
                .outgoingRegDate(incomingDocument.getOutgoingRegDate())
                .build();
    }

    public IncomingDocJpa modelToJpa(IncomingDocModel incomingDocModel) {
        IncomingDocJpa incomingDocJPA = new IncomingDocJpa();
        incomingDocJPA.setId(incomingDocModel.getId());
        incomingDocJPA.setName(incomingDocModel.getName());
        incomingDocJPA.setText(incomingDocModel.getText());
        incomingDocJPA.setRegNumber(incomingDocModel.getRegNumber());
        incomingDocJPA.setRegDate(incomingDocModel.getRegDate());
        incomingDocJPA.setOutgoingNumber(incomingDocModel.getOutgoingNumber());
        incomingDocJPA.setOutgoingRegDate(incomingDocModel.getOutgoingRegDate());
        return incomingDocJPA;
    }

    public IncomingDocResponseDto jpaToResponseDto(IncomingDocJpa documentJPA) {
        IncomingDocResponseDto incomingDocResponseDTO = new IncomingDocResponseDto();
        incomingDocResponseDTO.setName(documentJPA.getName());
        incomingDocResponseDTO.setText(documentJPA.getText());
        incomingDocResponseDTO.setAuthor(documentJPA.getAuthor().getSurname());
        incomingDocResponseDTO.setOutgoingNumber(documentJPA.getOutgoingNumber());
        incomingDocResponseDTO.setRecipient(documentJPA.getRecipient().getSurname());
        incomingDocResponseDTO.setSender(documentJPA.getSender().getSurname());
        incomingDocResponseDTO.setOutgoingRegDate(documentJPA.getOutgoingRegDate());
        return incomingDocResponseDTO;
    }

    public IncomingDocModel requestDtoToModel(IncomingDocRequestDto incomingDocRequestDTO) {
        IncomingDocModel.IncomingDocumentModelBuilder builder = new IncomingDocModel.IncomingDocumentModelBuilder();
        return builder
                .name(incomingDocRequestDTO.getName())
                .text(incomingDocRequestDTO.getText())
                .authorId(incomingDocRequestDTO.getAuthorId())
                .senderId(incomingDocRequestDTO.getSenderId())
                .recipientId(incomingDocRequestDTO.getRecipientId())
                .build();
    }
}
