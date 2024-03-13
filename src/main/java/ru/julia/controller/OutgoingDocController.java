package ru.julia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.julia.dto.request.OutgoingDocRequestDto;
import ru.julia.dto.response.OutgoingDocResponseDto;
import ru.julia.mapper.OutgoingDocumentMapper;
import ru.julia.servicelayer.service.OutgoingDocumentService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/outgoing_documents")
public class OutgoingDocController {
    @Autowired
    private OutgoingDocumentService service;
    @Autowired
    private OutgoingDocumentMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody OutgoingDocRequestDto outgoingDocRequestDto) {
        service.create(mapper.requestDtoToModel(outgoingDocRequestDto));
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

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") UUID id) {
        service.delete(id);
    }
}
