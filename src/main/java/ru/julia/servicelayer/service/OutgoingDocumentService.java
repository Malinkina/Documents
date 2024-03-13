package ru.julia.servicelayer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.dto.response.OutgoingDocResponseDto;
import ru.julia.exception.DocumentExistsException;
import ru.julia.infogenerator.DocumentInfoGenerator;
import ru.julia.mapper.OutgoingDocumentMapper;
import ru.julia.orm.jpamodel.EmployeeJpa;
import ru.julia.orm.jpamodel.OutgoingDocJpa;
import ru.julia.orm.repository.EmployeeRepository;
import ru.julia.orm.repository.OutgoingDocRepository;
import ru.julia.servicelayer.RegNumbersStorage;
import ru.julia.servicelayer.model.OutgoingDocModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class OutgoingDocumentService {
    @Autowired
    private OutgoingDocRepository outgoingDocRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private OutgoingDocumentMapper mapper;
    @Autowired
    private DocumentInfoGenerator documentGenerator;

    public void create(OutgoingDocModel outgoingDocModel) {
        UUID recipientId = outgoingDocModel.getRecipientId();
        EmployeeJpa recipient = employeeRepository.findById(recipientId)
                .orElseThrow(() -> new RuntimeException(
                        "Recipient with id " + recipientId + " not found")
                );
        UUID authorId = outgoingDocModel.getAuthorId();
        EmployeeJpa author = employeeRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException(
                        "Author with id " + authorId + " not found")
                );
        if (outgoingDocModel.getId() == 0) {
            setDTOMissingFields(outgoingDocModel);
        }
        OutgoingDocJpa outgoingDocJPA = mapper.modelToJpa(outgoingDocModel);
        outgoingDocJPA.setRecipient(recipient);
        outgoingDocJPA.setAuthor(author);
        outgoingDocRepository.save(outgoingDocJPA);
    }

    public OutgoingDocResponseDto read(UUID id) {
        Optional<OutgoingDocJpa> outgoingDocumentJPA = outgoingDocRepository.findById(id);
        return outgoingDocumentJPA.map(documentJpa -> mapper.jpaToResponseDto(documentJpa))
                .orElseThrow(() -> new RuntimeException(("Outgoing document with id %s not found".formatted(id))));
    }

    public List<OutgoingDocResponseDto> readAll() {
        List<OutgoingDocJpa> outgoingDocJPAS = (List<OutgoingDocJpa>) outgoingDocRepository.findAll();
        List<OutgoingDocResponseDto> outgoingDocResponseDTOS = new ArrayList<>();
        outgoingDocJPAS.forEach(outgoingDoc -> outgoingDocResponseDTOS.add(mapper.jpaToResponseDto(outgoingDoc)));
        return outgoingDocResponseDTOS;
    }

    public void delete(UUID id) {
        outgoingDocRepository.deleteById(id);
    }

    private void setDTOMissingFields(OutgoingDocModel outgoingDocModel) {
        outgoingDocModel.setId(documentGenerator.generateId());
        String regNumber = documentGenerator.generateRegNumber();
        try {
            RegNumbersStorage.add(regNumber);
        } catch (DocumentExistsException e) {
            throw new RuntimeException(e);
        }
        outgoingDocModel.setRegNumber(regNumber);
        outgoingDocModel.setRegDate(documentGenerator.generateRegDate());
    }
}
