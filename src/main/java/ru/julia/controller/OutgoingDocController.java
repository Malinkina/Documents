package ru.julia.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.julia.controller.dto.request.OutgoingDocRequestDto;
import ru.julia.controller.dto.response.OutgoingDocResponseDto;
import ru.julia.mapper.document.outgoing.OutgoingDocRequestDtoModelMapper;
import ru.julia.servicelayer.service.OutgoingDocumentService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/outgoing_documents")
public class OutgoingDocController {
    @Autowired
    private OutgoingDocumentService service;
    @Autowired
    private OutgoingDocRequestDtoModelMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@Valid @RequestBody OutgoingDocRequestDto outgoingDocRequestDto) {
        service.create(mapper.toModel(outgoingDocRequestDto));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OutgoingDocResponseDto> readAll() {
        return service.readAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OutgoingDocResponseDto read(@PathVariable("id") UUID id) {
        return service.read(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") UUID id, @RequestBody OutgoingDocRequestDto outgoingDocRequestDto) {
        service.update(id, mapper.toModel(outgoingDocRequestDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") UUID id) {
        service.delete(id);
    }
}
