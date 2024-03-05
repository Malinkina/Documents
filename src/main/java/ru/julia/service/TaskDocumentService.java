package ru.julia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.orm.jpamodel.EmployeeJPA;
import ru.julia.orm.jpamodel.TaskDocumentJPA;
import ru.julia.orm.repository.EmployeeRepository;
import ru.julia.orm.repository.TaskDocumentRepository;
import ru.julia.service.mapper.TaskDocumentMapper;
import ru.julia.service.modelforservice.TaskDocumentModel;

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
    public void create(TaskDocumentModel taskDocumentModel) {
        UUID responsibleExecutiveId = taskDocumentModel.getResponsibleExecutiveId();
        EmployeeJPA responsibleExecutive = employeeRepository.findById(responsibleExecutiveId)
                .orElseThrow(() -> new RuntimeException(
                        "Responsible executive with id " + responsibleExecutiveId + " not found")
                );
        UUID authorId = taskDocumentModel.getAuthor().getId();
        EmployeeJPA author = employeeRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException(
                        "Author with id " + authorId + " not found")
                );
        UUID controllerId = taskDocumentModel.getControllerId();
        EmployeeJPA controller = employeeRepository.findById(controllerId)
                .orElseThrow(() -> new RuntimeException(
                        "Controller with id " + controllerId + " not found")
                );
        TaskDocumentJPA taskDocumentJPA = mapper.taskDocumentModelToTaskDocumentJpa(taskDocumentModel);
        taskDocumentJPA.setAuthor(author);
        taskDocumentJPA.setResponsibleExecutive(responsibleExecutive);
        taskDocumentJPA.setController(controller);
        taskDocumentRepository.save(taskDocumentJPA);
    }
    public Optional<TaskDocumentJPA> read(UUID id) {
        return taskDocumentRepository.findById(id);
    }

    public Iterable<TaskDocumentJPA> readAll() {
        return taskDocumentRepository.findAll();
    }

    public void delete(UUID id) {
        taskDocumentRepository.deleteById(id);
    }
}
