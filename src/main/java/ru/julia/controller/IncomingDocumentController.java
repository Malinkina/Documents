package ru.julia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.julia.dto.request.IncomingDocumentRequestDTO;
import ru.julia.dto.response.IncomingDocumentResponseDTO;
import ru.julia.mapper.IncomingDocumentMapper;
import ru.julia.servicelayer.service.IncomingDocumentService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/incoming_documents")
public class IncomingDocumentController {
    @Autowired
    private IncomingDocumentService service;
    @Autowired
    private IncomingDocumentMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody IncomingDocumentRequestDTO incomingDocumentRequestDTO) {
        service.create(mapper.requestDtoToModel(incomingDocumentRequestDTO));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<IncomingDocumentResponseDTO> readAll() {
        return service.readAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public IncomingDocumentResponseDTO read(@PathVariable("id") UUID id) {
        return service.read(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") UUID id) {
        service.delete(id);
    }
}
