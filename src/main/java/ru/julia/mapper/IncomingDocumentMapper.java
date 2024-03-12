package ru.julia.mapper;

import org.springframework.stereotype.Component;
import ru.julia.document.IncomingDocument;
import ru.julia.dto.request.IncomingDocumentRequestDTO;
import ru.julia.dto.response.IncomingDocumentResponseDTO;
import ru.julia.orm.jpamodel.IncomingDocumentJPA;
import ru.julia.servicelayer.model.IncomingDocumentModel;

@Component
public class IncomingDocumentMapper {
    public IncomingDocumentModel incomingDocumentToModel(IncomingDocument incomingDocument) {
        IncomingDocumentModel.IncomingDocumentModelBuilder builder = new IncomingDocumentModel.IncomingDocumentModelBuilder();
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

    public IncomingDocumentJPA modelToJpa(IncomingDocumentModel incomingDocumentModel) {
        IncomingDocumentJPA incomingDocumentJPA = new IncomingDocumentJPA();
        incomingDocumentJPA.setId(incomingDocumentModel.getId());
        incomingDocumentJPA.setName(incomingDocumentModel.getName());
        incomingDocumentJPA.setText(incomingDocumentModel.getText());
        incomingDocumentJPA.setRegNumber(incomingDocumentModel.getRegNumber());
        incomingDocumentJPA.setRegDate(incomingDocumentModel.getRegDate());
        incomingDocumentJPA.setOutgoingNumber(incomingDocumentModel.getOutgoingNumber());
        incomingDocumentJPA.setOutgoingRegDate(incomingDocumentModel.getOutgoingRegDate());
        return incomingDocumentJPA;
    }

    public IncomingDocumentResponseDTO jpaToResponseDTO(IncomingDocumentJPA documentJPA) {
        IncomingDocumentResponseDTO incomingDocumentResponseDTO = new IncomingDocumentResponseDTO();
        incomingDocumentResponseDTO.setName(documentJPA.getName());
        incomingDocumentResponseDTO.setText(documentJPA.getText());
        incomingDocumentResponseDTO.setAuthor(documentJPA.getAuthor().getSurname());
        incomingDocumentResponseDTO.setOutgoingNumber(documentJPA.getOutgoingNumber());
        incomingDocumentResponseDTO.setRecipient(documentJPA.getRecipient().getSurname());
        incomingDocumentResponseDTO.setSender(documentJPA.getSender().getSurname());
        incomingDocumentResponseDTO.setOutgoingRegDate(documentJPA.getOutgoingRegDate());
        return incomingDocumentResponseDTO;
    }

    public IncomingDocumentModel requestDtoToModel(IncomingDocumentRequestDTO incomingDocumentRequestDTO) {
        IncomingDocumentModel.IncomingDocumentModelBuilder builder = new IncomingDocumentModel.IncomingDocumentModelBuilder();
        return builder
                .name(incomingDocumentRequestDTO.getName())
                .text(incomingDocumentRequestDTO.getText())
                .authorId(incomingDocumentRequestDTO.getAuthorId())
                .senderId(incomingDocumentRequestDTO.getSenderId())
                .recipientId(incomingDocumentRequestDTO.getRecipientId())
                .build();
    }
}
