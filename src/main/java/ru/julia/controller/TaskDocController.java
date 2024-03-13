package ru.julia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.julia.dto.request.TaskDocRequestDto;
import ru.julia.dto.response.TaskDocResponseDto;
import ru.julia.mapper.TaskDocumentMapper;
import ru.julia.servicelayer.service.TaskDocumentService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task_documents")
public class TaskDocController {
    @Autowired
    private TaskDocumentService service;
    @Autowired
    private TaskDocumentMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody TaskDocRequestDto taskDocRequestDto) {
        service.create(mapper.requestDtoToModel(taskDocRequestDto));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TaskDocResponseDto> readAll() {
        return service.readAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskDocResponseDto read(@PathVariable("id") UUID id) {
        return service.read(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") UUID id) {
        service.delete(id);
    }
}
