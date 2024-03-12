package ru.julia.servicelayer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.dto.response.TaskDocumentResponseDTO;
import ru.julia.exception.DocumentExistsException;
import ru.julia.infogenerator.DocumentInfoGenerator;
import ru.julia.infogenerator.TaskDocumentInfoGenerator;
import ru.julia.mapper.TaskDocumentMapper;
import ru.julia.orm.jpamodel.EmployeeJPA;
import ru.julia.orm.jpamodel.TaskDocumentJPA;
import ru.julia.orm.repository.EmployeeRepository;
import ru.julia.orm.repository.TaskDocumentRepository;
import ru.julia.servicelayer.RegNumbersStorage;
import ru.julia.servicelayer.model.TaskDocumentModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class TaskDocumentService {
    @Autowired
    private TaskDocumentRepository taskDocumentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private TaskDocumentMapper mapper;
    @Autowired
    private TaskDocumentInfoGenerator taskDocumentInfoGenerator;
    @Autowired
    private DocumentInfoGenerator documentGenerator;
    public void create(TaskDocumentModel taskDocumentModel) {
        UUID responsibleExecutiveId = taskDocumentModel.getResponsibleExecutiveId();
        EmployeeJPA responsibleExecutive = employeeRepository.findById(responsibleExecutiveId)
                .orElseThrow(() -> new RuntimeException(
                        "Responsible executive with id %s not found".formatted(responsibleExecutiveId))
                );
        UUID authorId = taskDocumentModel.getAuthorId();
        EmployeeJPA author = employeeRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException(
                        "Author with id %s not found".formatted(authorId))
                );
        UUID controllerId = taskDocumentModel.getControllerId();
        EmployeeJPA controller = employeeRepository.findById(controllerId)
                .orElseThrow(() -> new RuntimeException(
                        "Controller with id %s not found".formatted(controllerId))
                );
        if (taskDocumentModel.getId() == 0) {
            setDTOMissingFields(taskDocumentModel);
        }
        TaskDocumentJPA taskDocumentJPA = mapper.modelToJpa(taskDocumentModel);
        taskDocumentJPA.setAuthor(author);
        taskDocumentJPA.setResponsibleExecutive(responsibleExecutive);
        taskDocumentJPA.setController(controller);
        taskDocumentRepository.save(taskDocumentJPA);
    }
    public TaskDocumentResponseDTO read(UUID id) {
        Optional<TaskDocumentJPA> taskDocumentJPA = taskDocumentRepository.findById(id);
        return taskDocumentJPA.map(documentJpa -> mapper.jpaToResponseDto(documentJpa))
                .orElseThrow(() -> new RuntimeException(("Task document with id %s not found".formatted(id))));
    }

    public List<TaskDocumentResponseDTO> readAll() {
        List<TaskDocumentJPA> taskDocumentJPAs = (List<TaskDocumentJPA>) taskDocumentRepository.findAll();
        List<TaskDocumentResponseDTO> taskDocumentResponseDTOS = new ArrayList<>();
        taskDocumentJPAs.forEach(taskDoc -> taskDocumentResponseDTOS.add(mapper.jpaToResponseDto(taskDoc)));
        return taskDocumentResponseDTOS;
    }

    public void delete(UUID id) {
        taskDocumentRepository.deleteById(id);
    }

    private void setDTOMissingFields(TaskDocumentModel taskDocumentModel) {
        taskDocumentModel.setId(documentGenerator.generateId());
        String regNumber = documentGenerator.generateRegNumber();
        try {
            RegNumbersStorage.add(regNumber);
        } catch (DocumentExistsException e) {
            throw new RuntimeException(e);
        }
        taskDocumentModel.setRegNumber(regNumber);
        taskDocumentModel.setRegDate(documentGenerator.generateRegDate());
        taskDocumentModel.setIssueDate(taskDocumentInfoGenerator.generateIssueDate());
    }
}
