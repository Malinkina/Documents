package ru.julia.mapper;

import org.springframework.stereotype.Component;
import ru.julia.document.TaskDocument;
import ru.julia.dto.request.TaskDocumentRequestDTO;
import ru.julia.dto.response.TaskDocumentResponseDTO;
import ru.julia.orm.jpamodel.TaskDocumentJPA;
import ru.julia.servicelayer.model.TaskDocumentModel;
@Component
public class TaskDocumentMapper {
    public TaskDocumentModel taskDocumentToModel(TaskDocument taskDocument) {
        TaskDocumentModel.TaskDocumentModelBuilder builder = new TaskDocumentModel.TaskDocumentModelBuilder();
        return builder
                .id(taskDocument.getId())
                .name(taskDocument.getName())
                .text(taskDocument.getText())
                .regNumber(taskDocument.getRegNumber())
                .regDate(taskDocument.getRegDate())
                .authorId(taskDocument.getAuthor().getId())
                .issueDate(taskDocument.getIssueDate())
                .executionTerm(taskDocument.getExecutionTerm())
                .responsibleExecutiveId(taskDocument.getResponsibleExecutive().getId())
                .controlMark(taskDocument.isControlMark())
                .controllerId(taskDocument.getController().getId())
                .build();
    }
    public TaskDocumentJPA modelToJpa(TaskDocumentModel taskDocumentModel) {
        TaskDocumentJPA taskDocumentJPA = new TaskDocumentJPA();
        taskDocumentJPA.setId(taskDocumentModel.getId());
        taskDocumentJPA.setName(taskDocumentModel.getName());
        taskDocumentJPA.setText(taskDocumentModel.getText());
        taskDocumentJPA.setRegNumber(taskDocumentModel.getRegNumber());
        taskDocumentJPA.setRegDate(taskDocumentModel.getRegDate());
        taskDocumentJPA.setIssueDate(taskDocumentModel.getIssueDate());
        taskDocumentJPA.setExecutionTerm(taskDocumentModel.getExecutionTerm());
        taskDocumentJPA.setControlMark(taskDocumentModel.isControlMark());
        return taskDocumentJPA;
    }

    public TaskDocumentResponseDTO jpaToResponseDto(TaskDocumentJPA taskDocumentJPA) {
        TaskDocumentResponseDTO taskDocumentResponseDTO = new TaskDocumentResponseDTO();
        taskDocumentResponseDTO.setName(taskDocumentJPA.getName());
        taskDocumentResponseDTO.setText(taskDocumentJPA.getText());
        taskDocumentResponseDTO.setAuthor(taskDocumentJPA.getAuthor().getSurname());
        taskDocumentResponseDTO.setIssueDate(taskDocumentJPA.getIssueDate());
        taskDocumentResponseDTO.setExecutionTerm(taskDocumentJPA.getExecutionTerm());
        taskDocumentResponseDTO.setResponsibleExecutive(taskDocumentJPA.getResponsibleExecutive().getSurname());
        taskDocumentResponseDTO.setControlMark(taskDocumentJPA.isControlMark());
        taskDocumentResponseDTO.setController(taskDocumentJPA.getController().getSurname());
        return taskDocumentResponseDTO;
    }

    public TaskDocumentModel requestDtoToModel(TaskDocumentRequestDTO taskDocumentRequestDTO) {
        TaskDocumentModel.TaskDocumentModelBuilder builder = new TaskDocumentModel.TaskDocumentModelBuilder();
        return builder
                .name(taskDocumentRequestDTO.getName())
                .text(taskDocumentRequestDTO.getText())
                .authorId(taskDocumentRequestDTO.getAuthorId())
                .executionTerm(taskDocumentRequestDTO.getExecutionTerm())
                .responsibleExecutiveId(taskDocumentRequestDTO.getResponsibleExecutiveId())
                .controlMark(taskDocumentRequestDTO.isControlMark())
                .controllerId(taskDocumentRequestDTO.getControllerId())
                .build();
    }
}
