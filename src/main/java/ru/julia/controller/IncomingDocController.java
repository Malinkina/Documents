package ru.julia.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.julia.controller.dto.request.IncomingDocRequestDto;
import ru.julia.controller.dto.response.IncomingDocResponseDto;
import ru.julia.mapper.document.incoming.IncomingDocRequestDtoModelMapper;
import ru.julia.servicelayer.service.IncomingDocumentService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/incoming_document")
public class IncomingDocController {
    @Autowired
    private IncomingDocumentService service;
    @Autowired
    private IncomingDocRequestDtoModelMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('CREATE_DOCUMENT')")
    public UUID create(@Valid @RequestBody IncomingDocRequestDto incomingDocRequestDto) {
        return service.create(mapper.toModel(incomingDocRequestDto));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ_DOCUMENT')")
    public List<IncomingDocResponseDto> readAll() {
        return service.readAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ_DOCUMENT')")
    public IncomingDocResponseDto read(@PathVariable("id") UUID id) {
        return service.read(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('UPDATE_DOCUMENT')")
    public void update(@PathVariable("id") UUID id, @RequestBody IncomingDocRequestDto incomingDocRequestDto) {
        service.update(id, mapper.toModel(incomingDocRequestDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('DELETE_DOCUMENT')")
    public void delete(@PathVariable("id") UUID id) {
        service.delete(id);
    }
}
