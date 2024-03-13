package ru.julia.servicelayer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.dto.response.TaskDocResponseDto;
import ru.julia.exception.DocumentExistsException;
import ru.julia.infogenerator.DocumentInfoGenerator;
import ru.julia.infogenerator.TaskDocInfoGenerator;
import ru.julia.mapper.TaskDocumentMapper;
import ru.julia.orm.jpamodel.EmployeeJpa;
import ru.julia.orm.jpamodel.TaskDocJpa;
import ru.julia.orm.repository.EmployeeRepository;
import ru.julia.orm.repository.TaskDocRepository;
import ru.julia.servicelayer.RegNumbersStorage;
import ru.julia.servicelayer.model.TaskDocModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class TaskDocumentService {
    @Autowired
    private TaskDocRepository taskDocRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private TaskDocumentMapper mapper;
    @Autowired
    private TaskDocInfoGenerator taskDocInfoGenerator;
    @Autowired
    private DocumentInfoGenerator documentGenerator;
    public void create(TaskDocModel taskDocModel) {
        UUID responsibleExecutiveId = taskDocModel.getResponsibleExecutiveId();
        EmployeeJpa responsibleExecutive = employeeRepository.findById(responsibleExecutiveId)
                .orElseThrow(() -> new RuntimeException(
                        "Responsible executive with id %s not found".formatted(responsibleExecutiveId))
                );
        UUID authorId = taskDocModel.getAuthorId();
        EmployeeJpa author = employeeRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException(
                        "Author with id %s not found".formatted(authorId))
                );
        UUID controllerId = taskDocModel.getControllerId();
        EmployeeJpa controller = employeeRepository.findById(controllerId)
                .orElseThrow(() -> new RuntimeException(
                        "Controller with id %s not found".formatted(controllerId))
                );
        if (taskDocModel.getId() == 0) {
            setDTOMissingFields(taskDocModel);
        }
        TaskDocJpa taskDocJPA = mapper.modelToJpa(taskDocModel);
        taskDocJPA.setAuthor(author);
        taskDocJPA.setResponsibleExecutive(responsibleExecutive);
        taskDocJPA.setController(controller);
        taskDocRepository.save(taskDocJPA);
    }
    public TaskDocResponseDto read(UUID id) {
        Optional<TaskDocJpa> taskDocumentJPA = taskDocRepository.findById(id);
        return taskDocumentJPA.map(documentJpa -> mapper.jpaToResponseDto(documentJpa))
                .orElseThrow(() -> new RuntimeException(("Task document with id %s not found".formatted(id))));
    }

    public List<TaskDocResponseDto> readAll() {
        List<TaskDocJpa> taskDocJPAS = (List<TaskDocJpa>) taskDocRepository.findAll();
        List<TaskDocResponseDto> taskDocResponseDTOS = new ArrayList<>();
        taskDocJPAS.forEach(taskDoc -> taskDocResponseDTOS.add(mapper.jpaToResponseDto(taskDoc)));
        return taskDocResponseDTOS;
    }

    public void delete(UUID id) {
        taskDocRepository.deleteById(id);
    }

    private void setDTOMissingFields(TaskDocModel taskDocModel) {
        taskDocModel.setId(documentGenerator.generateId());
        String regNumber = documentGenerator.generateRegNumber();
        try {
            RegNumbersStorage.add(regNumber);
        } catch (DocumentExistsException e) {
            throw new RuntimeException(e);
        }
        taskDocModel.setRegNumber(regNumber);
        taskDocModel.setRegDate(documentGenerator.generateRegDate());
        taskDocModel.setIssueDate(taskDocInfoGenerator.generateIssueDate());
    }
}
