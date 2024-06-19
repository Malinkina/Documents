package ru.julia.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.julia.controller.dto.request.TaskDocRequestDto;
import ru.julia.controller.dto.response.TaskDocResponseDto;
import ru.julia.mapper.document.task.TaskDocRequestDtoModelMapper;
import ru.julia.servicelayer.service.TaskDocumentService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task_documents")
public class TaskDocController {
    @Autowired
    private TaskDocumentService service;
    @Autowired
    private TaskDocRequestDtoModelMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@Valid @RequestBody TaskDocRequestDto taskDocRequestDto) {
        service.create(mapper.toModel(taskDocRequestDto));
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
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") UUID id, @RequestBody TaskDocRequestDto taskDocRequestDto) {
        service.update(id, mapper.toModel(taskDocRequestDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") UUID id) {
        service.delete(id);
    }
}
