package ru.julia.servicelayer.service;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class TaskDocumentService {
    private final TaskDocRepository taskDocRepository;
    private final EmployeeRepository employeeRepository;
    private final TaskDocInfoGenerator taskDocInfoGenerator;
    private final DocumentInfoGenerator documentGenerator;
    private final TaskDocModelJpaMapper modelJpaMapper;
    private final TaskDocJpaResponseDtoMapper jpaResponseDtoMapper;
    private final RegNumbersStorage storage;
    private final CurrentEmployeeService employeeService;

    public UUID create(TaskDocModel taskDocModel) {
        if (taskDocModel.getId() == null) {
            setDTOMissingFields(taskDocModel);
        }
        TaskDocJpa taskDocJpa = modelJpaMapper.toJpa(taskDocModel);
        setEmployees(taskDocModel, taskDocJpa);
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

    public void update(UUID id, TaskDocModel taskDocModel) {
        TaskDocJpa taskDocJpa = taskDocRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task document with id %s not found".formatted(id)));
        modelJpaMapper.updateJpaFromModel(taskDocModel, taskDocJpa);
        taskDocRepository.save(taskDocJpa);
    }

    public void delete(UUID id) {
        taskDocRepository.deleteById(id);
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

    private void setEmployees(TaskDocModel taskDocModel, TaskDocJpa taskDocJpa) {
        EmployeeJpa author = employeeService.getCurrentUser();
        EmployeeJpa controller = findEmployeeJpa(taskDocModel.getControllerId());
        EmployeeJpa responsibleExecutive = findEmployeeJpa(taskDocModel.getResponsibleExecutiveId());
        taskDocJpa.setAuthor(author);
        taskDocJpa.setController(controller);
        taskDocJpa.setResponsibleExecutive(responsibleExecutive);
    }

    private EmployeeJpa findEmployeeJpa(UUID id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException(
                "Employee with id %s not found".formatted(id)));
    }
}
