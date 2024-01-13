package ru.julia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.julia.domain.Document;
import ru.julia.dto.DocumentDTO;
import ru.julia.service.DocumentService;

import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DocumentDTO get(@PathVariable("id") String id) {
        return documentService.read(id);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DocumentDTO> getAll() {
        return documentService.readAll();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") String id, @RequestBody Document document) {
        documentService.update(id, document);
    }
}
