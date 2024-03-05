package ru.julia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.orm.jpamodel.EmployeeJPA;
import ru.julia.orm.jpamodel.IncomingDocumentJPA;
import ru.julia.orm.repository.EmployeeRepository;
import ru.julia.orm.repository.IncomingDocumentRepository;
import ru.julia.service.mapper.IncomingDocumentMapper;
import ru.julia.service.modelforservice.IncomingDocumentModel;

import java.util.UUID;

@Component
public class IncomingDocumentService {
    @Autowired
    private IncomingDocumentRepository incomingDocumentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private IncomingDocumentMapper mapper;

    public void create(IncomingDocumentModel incomingDocumentModel) {
        UUID recipientId = incomingDocumentModel.getRecipientId();
        EmployeeJPA recipient = employeeRepository.findById(recipientId)
                .orElseThrow(() -> new RuntimeException(
                        "Recipient with id " + recipientId + " not found")
                );
        UUID senderId = incomingDocumentModel.getSenderId();
        EmployeeJPA sender = employeeRepository.findById(senderId)
                .orElseThrow(() -> new RuntimeException(
                        "Sender with id " + senderId + " not found")
                );
        UUID authorId = incomingDocumentModel.getAuthor().getId();
        EmployeeJPA author = employeeRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException(
                        "Author with id " + authorId + " not found")
                );
        IncomingDocumentJPA incomingDocumentJPA = mapper.incomingDocumentModelToIncomingDocumentJpa(incomingDocumentModel);
        incomingDocumentJPA.setSender(sender);
        incomingDocumentJPA.setRecipient(recipient);
        incomingDocumentJPA.setAuthor(author);
        incomingDocumentRepository.save(incomingDocumentJPA);
    }
}
