package ru.julia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.orm.jpamodel.DocumentJPA;
import ru.julia.orm.jpamodel.EmployeeJPA;
import ru.julia.orm.jpamodel.OutgoingDocumentJPA;
import ru.julia.orm.repository.DocumentRepository;
import ru.julia.orm.repository.EmployeeRepository;
import ru.julia.orm.repository.OutgoingDocumentRepository;
import ru.julia.service.mapper.OutgoingDocumentMapper;
import ru.julia.service.modelforservice.OutgoingDocumentModel;

import java.util.Optional;
import java.util.UUID;

@Component
public class OutgoingDocumentService {
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private OutgoingDocumentRepository outgoingDocumentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private OutgoingDocumentMapper mapper;

    public void create(OutgoingDocumentModel outgoingDocumentModel) {
        UUID recipientId = outgoingDocumentModel.getRecipientId();
        EmployeeJPA employeeJPA = employeeRepository.findById(recipientId)
                .orElseThrow(() -> new RuntimeException("Employee with id " + recipientId + " not found"));
        UUID documentId = outgoingDocumentModel.getDocumentId();
        DocumentJPA documentJPA = documentRepository.findById(outgoingDocumentModel.getDocumentId())
                .orElseThrow(() -> new RuntimeException("Document with id " + documentId + " not found"));
        OutgoingDocumentJPA outgoingDocumentJPA = mapper.outgoingDocumentModelToOutgoingDocumentJpa(outgoingDocumentModel);
        outgoingDocumentJPA.setRecipient(employeeJPA);
        outgoingDocumentJPA.setDocument(documentJPA);
    }

    public Optional<OutgoingDocumentJPA> read(UUID id) {
        return outgoingDocumentRepository.findById(id);
    }

    public Iterable<OutgoingDocumentJPA> readAll() {
        return outgoingDocumentRepository.findAll();
    }

    public void delete(UUID id) {
        outgoingDocumentRepository.deleteById(id);
    }
}
