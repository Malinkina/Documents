package ru.julia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.orm.jpamodel.EmployeeJPA;
import ru.julia.orm.jpamodel.OutgoingDocumentJPA;
import ru.julia.orm.repository.EmployeeRepository;
import ru.julia.orm.repository.OutgoingDocumentRepository;
import ru.julia.service.mapper.OutgoingDocumentMapper;
import ru.julia.service.modelforservice.OutgoingDocumentModel;

import java.util.Optional;
import java.util.UUID;

@Component
public class OutgoingDocumentService {
    @Autowired
    private OutgoingDocumentRepository outgoingDocumentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private OutgoingDocumentMapper mapper;

    public void create(OutgoingDocumentModel outgoingDocumentModel) {
        UUID recipientId = outgoingDocumentModel.getRecipientId();
        EmployeeJPA recipient = employeeRepository.findById(recipientId)
                .orElseThrow(() -> new RuntimeException(
                        "Recipient with id " + recipientId + " not found")
                );
        UUID authorId = outgoingDocumentModel.getAuthor().getId();
        EmployeeJPA author = employeeRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException(
                        "Author with id " + authorId + " not found")
                );
        OutgoingDocumentJPA outgoingDocumentJPA = mapper.outgoingDocumentModelToOutgoingDocumentJpa(outgoingDocumentModel);
        outgoingDocumentJPA.setRecipient(recipient);
        outgoingDocumentJPA.setAuthor(author);
        outgoingDocumentRepository.save(outgoingDocumentJPA);
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
