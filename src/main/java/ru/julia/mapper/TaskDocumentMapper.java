package ru.julia.mapper;

import org.springframework.stereotype.Component;
import ru.julia.document.TaskDocument;
import ru.julia.dto.request.TaskDocRequestDto;
import ru.julia.dto.response.TaskDocResponseDto;
import ru.julia.orm.jpamodel.TaskDocJpa;
import ru.julia.servicelayer.model.TaskDocModel;
@Component
public class TaskDocumentMapper {
    public TaskDocModel taskDocumentToModel(TaskDocument taskDocument) {
        TaskDocModel.TaskDocumentModelBuilder builder = new TaskDocModel.TaskDocumentModelBuilder();
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
    public TaskDocJpa modelToJpa(TaskDocModel taskDocModel) {
        TaskDocJpa taskDocJPA = new TaskDocJpa();
        taskDocJPA.setId(taskDocModel.getId());
        taskDocJPA.setName(taskDocModel.getName());
        taskDocJPA.setText(taskDocModel.getText());
        taskDocJPA.setRegNumber(taskDocModel.getRegNumber());
        taskDocJPA.setRegDate(taskDocModel.getRegDate());
        taskDocJPA.setIssueDate(taskDocModel.getIssueDate());
        taskDocJPA.setExecutionTerm(taskDocModel.getExecutionTerm());
        taskDocJPA.setControlMark(taskDocModel.isControlMark());
        return taskDocJPA;
    }

    public TaskDocResponseDto jpaToResponseDto(TaskDocJpa taskDocJPA) {
        TaskDocResponseDto taskDocResponseDTO = new TaskDocResponseDto();
        taskDocResponseDTO.setName(taskDocJPA.getName());
        taskDocResponseDTO.setText(taskDocJPA.getText());
        taskDocResponseDTO.setAuthor(taskDocJPA.getAuthor().getSurname());
        taskDocResponseDTO.setIssueDate(taskDocJPA.getIssueDate());
        taskDocResponseDTO.setExecutionTerm(taskDocJPA.getExecutionTerm());
        taskDocResponseDTO.setResponsibleExecutive(taskDocJPA.getResponsibleExecutive().getSurname());
        taskDocResponseDTO.setControlMark(taskDocJPA.isControlMark());
        taskDocResponseDTO.setController(taskDocJPA.getController().getSurname());
        return taskDocResponseDTO;
    }

    public TaskDocModel requestDtoToModel(TaskDocRequestDto taskDocRequestDTO) {
        TaskDocModel.TaskDocumentModelBuilder builder = new TaskDocModel.TaskDocumentModelBuilder();
        return builder
                .name(taskDocRequestDTO.getName())
                .text(taskDocRequestDTO.getText())
                .authorId(taskDocRequestDTO.getAuthorId())
                .executionTerm(taskDocRequestDTO.getExecutionTerm())
                .responsibleExecutiveId(taskDocRequestDTO.getResponsibleExecutiveId())
                .controlMark(taskDocRequestDTO.isControlMark())
                .controllerId(taskDocRequestDTO.getControllerId())
                .build();
    }
}
