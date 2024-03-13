package ru.julia.servicelayer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.dto.response.IncomingDocResponseDto;
import ru.julia.exception.DocumentExistsException;
import ru.julia.infogenerator.DocumentInfoGenerator;
import ru.julia.infogenerator.IncomingDocInfoGenerator;
import ru.julia.orm.jpamodel.EmployeeJpa;
import ru.julia.orm.jpamodel.IncomingDocJpa;
import ru.julia.orm.repository.EmployeeRepository;
import ru.julia.orm.repository.IncomingDocRepository;
import ru.julia.servicelayer.RegNumbersStorage;
import ru.julia.mapper.IncomingDocumentMapper;
import ru.julia.servicelayer.model.IncomingDocModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class IncomingDocumentService {
    @Autowired
    private IncomingDocRepository incomingDocRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private IncomingDocumentMapper mapper;
    @Autowired
    private IncomingDocInfoGenerator incomingDocumentGenerator;
    @Autowired
    private DocumentInfoGenerator documentGenerator;

    public void create(IncomingDocModel incomingDocModel) {
        UUID recipientId = incomingDocModel.getRecipientId();
        EmployeeJpa recipient = employeeRepository.findById(recipientId)
                .orElseThrow(() -> new RuntimeException(
                        "Recipient with id %s not found".formatted(recipientId))
                );
        UUID senderId = incomingDocModel.getSenderId();
        EmployeeJpa sender = employeeRepository.findById(senderId)
                .orElseThrow(() -> new RuntimeException(
                        "Sender with id %s not found".formatted(senderId))
                );
        UUID authorId = incomingDocModel.getAuthorId();
        EmployeeJpa author = employeeRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException(
                        "Author with id %s not found".formatted(authorId))
                );
        if (incomingDocModel.getId() == 0) {
            setDTOMissingFields(incomingDocModel);
        }
        IncomingDocJpa incomingDocJPA = mapper.modelToJpa(incomingDocModel);
        incomingDocJPA.setSender(sender);
        incomingDocJPA.setRecipient(recipient);
        incomingDocJPA.setAuthor(author);
        incomingDocRepository.save(incomingDocJPA);
    }

    public IncomingDocResponseDto read(UUID id) {
        Optional<IncomingDocJpa> incomingDocumentJpa = incomingDocRepository.findById(id);
        return incomingDocumentJpa.map(documentJpa -> mapper.jpaToResponseDto(documentJpa))
                .orElseThrow(() -> new RuntimeException(("Incoming document with id %s not found".formatted(id))));
    }

    public List<IncomingDocResponseDto> readAll() {
        List<IncomingDocJpa> incomingDocJpas = (List<IncomingDocJpa>) incomingDocRepository.findAll();
        List<IncomingDocResponseDto> incomingDocResponseDtos = new ArrayList<>();
        incomingDocJpas.forEach(incDoc -> incomingDocResponseDtos.add(mapper.jpaToResponseDto(incDoc)));
        return incomingDocResponseDtos;
    }

    public void delete(UUID id) {
        incomingDocRepository.deleteById(id);
    }

    private void setDTOMissingFields(IncomingDocModel incomingDocModel) {
        incomingDocModel.setId(documentGenerator.generateId());
        String regNumber = documentGenerator.generateRegNumber();
        try {
            RegNumbersStorage.add(regNumber);
        } catch (DocumentExistsException e) {
            throw new RuntimeException(e);
        }
        incomingDocModel.setRegNumber(regNumber);
        incomingDocModel.setRegDate(LocalDate.now());
        incomingDocModel.setOutgoingNumber(incomingDocumentGenerator.generateOutgoingNumber());
        incomingDocModel.setOutgoingRegDate(incomingDocumentGenerator.generateRegDate());
    }
}
