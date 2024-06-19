package ru.julia.servicelayer.service;

import org.springframework.stereotype.Component;
import ru.julia.controller.dto.response.TaskDocResponseDto;
import ru.julia.exception.DocumentExistsException;
import ru.julia.infogenerator.DocumentInfoGenerator;
import ru.julia.infogenerator.TaskDocInfoGenerator;
import ru.julia.mapper.document.task.TaskDocJpaResponseDtoMapper;
import ru.julia.mapper.document.task.TaskDocModelJpaMapper;
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
    private final TaskDocRepository taskDocRepository;
    private final EmployeeRepository employeeRepository;
    private final TaskDocInfoGenerator taskDocInfoGenerator;
    private final DocumentInfoGenerator documentGenerator;
    private final TaskDocModelJpaMapper modelJpaMapper;
    private final TaskDocJpaResponseDtoMapper jpaResponseDtoMapper;
    private final RegNumbersStorage storage;

    public TaskDocumentService(TaskDocRepository taskDocRepository,
                               EmployeeRepository employeeRepository,
                               TaskDocInfoGenerator taskDocInfoGenerator,
                               DocumentInfoGenerator documentGenerator,
                               TaskDocModelJpaMapper modelJpaMapper,
                               TaskDocJpaResponseDtoMapper jpaResponseDtoMapper,
                               RegNumbersStorage storage) {
        this.taskDocRepository = taskDocRepository;
        this.employeeRepository = employeeRepository;
        this.taskDocInfoGenerator = taskDocInfoGenerator;
        this.documentGenerator = documentGenerator;
        this.modelJpaMapper = modelJpaMapper;
        this.jpaResponseDtoMapper = jpaResponseDtoMapper;
        this.storage = storage;
    }

    public UUID create(TaskDocModel taskDocModel) {
        if (taskDocModel.getId() == null) {
            setDTOMissingFields(taskDocModel);
        }
        TaskDocJpa taskDocJpa = modelJpaMapper.toJpa(taskDocModel);
        if (taskDocModel.getAuthorId() != null) {
            EmployeeJpa author = findEmployeeJpa(taskDocModel.getAuthorId(), "author");
            taskDocJpa.setAuthor(author);
        }

        if (taskDocModel.getResponsibleExecutiveId() != null) {
            EmployeeJpa responsibleExecutive = findEmployeeJpa(taskDocModel.getResponsibleExecutiveId(), "responsibleExecutive");
            taskDocJpa.setResponsibleExecutive(responsibleExecutive);
        }

        if (taskDocModel.getControllerId() != null) {
            EmployeeJpa controller = findEmployeeJpa(taskDocModel.getControllerId(), "controller");
            taskDocJpa.setController(controller);
        }

        taskDocRepository.save(taskDocJpa);
        return taskDocJpa.getId();
    }
    public TaskDocResponseDto read(UUID id) {
        Optional<TaskDocJpa> taskDocumentJPA = taskDocRepository.findById(id);
        return taskDocumentJPA.map(jpaResponseDtoMapper::toResponseDto)
                .orElseThrow(() -> new RuntimeException("Task document with id %s not found".formatted(id)));
    }

    public List<TaskDocResponseDto> readAll() {
        List<TaskDocJpa> taskDocJPAS = (List<TaskDocJpa>) taskDocRepository.findAll();
        List<TaskDocResponseDto> taskDocResponseDTOS = new ArrayList<>();
        taskDocJPAS.forEach(taskDoc -> taskDocResponseDTOS.add(jpaResponseDtoMapper.toResponseDto(taskDoc)));
        return taskDocResponseDTOS;
    }

    public void delete(UUID id) {
        taskDocRepository.deleteById(id);
    }

    public void update(UUID id, TaskDocModel taskDocModel) {
        TaskDocJpa taskDocJpa = taskDocRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task document with id %s not found".formatted(id)));
        modelJpaMapper.updateJpaFromModel(taskDocModel, taskDocJpa);
        taskDocRepository.save(taskDocJpa);
    }

    private EmployeeJpa findEmployeeJpa(UUID id, String employeeRole) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException(
                "%s with id %s not found".formatted(employeeRole, id)));
    }

    private void setDTOMissingFields(TaskDocModel taskDocModel) {
        taskDocModel.setDocId(documentGenerator.generateId());
        String regNumber = documentGenerator.generateRegNumber();
        try {
            storage.add(regNumber);
        } catch (DocumentExistsException e) {
            throw new RuntimeException(e);
        }
        taskDocModel.setRegNumber(regNumber);
        taskDocModel.setRegDate(documentGenerator.generateRegDate());
        taskDocModel.setIssueDate(taskDocInfoGenerator.generateIssueDate());
    }
}
