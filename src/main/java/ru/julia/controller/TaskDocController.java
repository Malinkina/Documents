package ru.julia.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.julia.controller.dto.request.TaskDocRequestDto;
import ru.julia.controller.dto.response.TaskDocResponseDto;
import ru.julia.mapper.document.task.TaskDocRequestDtoModelMapper;
import ru.julia.servicelayer.service.TaskDocumentService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task_document")
public class TaskDocController {
    @Autowired
    private TaskDocumentService service;
    @Autowired
    private TaskDocRequestDtoModelMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('CREATE_DOCUMENT')")
    public UUID create(@Valid @RequestBody TaskDocRequestDto taskDocRequestDto) {
        return service.create(mapper.toModel(taskDocRequestDto));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ_DOCUMENT')")
    public List<TaskDocResponseDto> readAll() {
        return service.readAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ_DOCUMENT')")
    public TaskDocResponseDto read(@PathVariable("id") UUID id) {
        return service.read(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('UPDATE_DOCUMENT')")
    public void update(@PathVariable("id") UUID id, @RequestBody TaskDocRequestDto taskDocRequestDto) {
        service.update(id, mapper.toModel(taskDocRequestDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('DELETE_DOCUMENT')")
    public void delete(@PathVariable("id") UUID id) {
        service.delete(id);
    }
}
