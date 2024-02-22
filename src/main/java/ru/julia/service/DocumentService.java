package ru.julia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.orm.jpamodel.DocumentJPA;
import ru.julia.orm.jpamodel.EmployeeJPA;
import ru.julia.orm.repository.DocumentRepository;
import ru.julia.orm.repository.EmployeeRepository;
import ru.julia.service.mapper.DocumentMapper;
import ru.julia.service.modelforservice.DocumentModel;

import java.util.Optional;
import java.util.UUID;

@Component
public class DocumentService {
    @Autowired
    private DocumentRepository repository;
    @Autowired
    private DocumentMapper mapper;
    @Autowired
    private EmployeeRepository employeeRepository;
    public void create(DocumentModel documentModel) {
        UUID authorId = documentModel.getAuthor().getId();
        EmployeeJPA employeeJPA = employeeRepository.findById(authorId)
                        .orElseThrow(() -> new RuntimeException("Author with id " + authorId + " not found"));
        DocumentJPA documentJPA = mapper.documentModelToDocumentJPA(documentModel);
        documentJPA.setAuthor(employeeJPA);
        repository.save(documentJPA);
    }

    public Optional<DocumentJPA> read(String id) {
        return repository.findById(id);
    }

    public Iterable<DocumentJPA> readAll() {
        return repository.findAll();
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}

