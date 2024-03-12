package ru.julia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.julia.dto.request.TaskDocumentRequestDTO;
import ru.julia.dto.response.TaskDocumentResponseDTO;
import ru.julia.mapper.TaskDocumentMapper;
import ru.julia.servicelayer.service.TaskDocumentService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task_documents")
public class TaskDocumentController {
    @Autowired
    private TaskDocumentService service;
    @Autowired
    private TaskDocumentMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody TaskDocumentRequestDTO taskDocumentRequestDTO) {
        service.create(mapper.requestDtoToModel(taskDocumentRequestDTO));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TaskDocumentResponseDTO> readAll() {
        return service.readAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskDocumentResponseDTO read(@PathVariable("id") UUID id) {
        return service.read(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") UUID id) {
        service.delete(id);
    }
}
