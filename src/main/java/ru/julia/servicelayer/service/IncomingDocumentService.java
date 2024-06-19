package ru.julia.servicelayer.service;

import org.springframework.stereotype.Component;
import ru.julia.controller.dto.response.IncomingDocResponseDto;
import ru.julia.exception.DocumentExistsException;
import ru.julia.infogenerator.DocumentInfoGenerator;
import ru.julia.infogenerator.IncomingDocInfoGenerator;
import ru.julia.mapper.document.incoming.IncomingDocJpaResponseDtoMapper;
import ru.julia.mapper.document.incoming.IncomingDocModelJpaMapper;
import ru.julia.orm.jpamodel.EmployeeJpa;
import ru.julia.orm.jpamodel.IncomingDocJpa;
import ru.julia.orm.repository.EmployeeRepository;
import ru.julia.orm.repository.IncomingDocRepository;
import ru.julia.servicelayer.RegNumbersStorage;
import ru.julia.servicelayer.model.IncomingDocModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class IncomingDocumentService {
    private final IncomingDocRepository incomingDocRepository;
    private final EmployeeRepository employeeRepository;
    private final IncomingDocInfoGenerator incomingDocumentGenerator;
    private final DocumentInfoGenerator documentGenerator;
    private final IncomingDocModelJpaMapper modelJpaMapper;
    private final IncomingDocJpaResponseDtoMapper jpaResponseDtoMapper;
    private final RegNumbersStorage storage;

    public IncomingDocumentService(IncomingDocRepository incomingDocRepository,
                                   EmployeeRepository employeeRepository,
                                   IncomingDocInfoGenerator incomingDocumentGenerator,
                                   DocumentInfoGenerator documentGenerator,
                                   IncomingDocModelJpaMapper modelJpaMapper,
                                   IncomingDocJpaResponseDtoMapper jpaResponseDtoMapper,
                                   RegNumbersStorage storage) {
        this.incomingDocRepository = incomingDocRepository;
        this.employeeRepository = employeeRepository;
        this.incomingDocumentGenerator = incomingDocumentGenerator;
        this.documentGenerator = documentGenerator;
        this.modelJpaMapper = modelJpaMapper;
        this.jpaResponseDtoMapper = jpaResponseDtoMapper;
        this.storage = storage;
    }

    public UUID create(IncomingDocModel incomingDocModel) {
        if (incomingDocModel.getId() == null) {
            setDtoMissingFields(incomingDocModel);
        }
        IncomingDocJpa incomingDocJpa = modelJpaMapper.toJpa(incomingDocModel);
        if (incomingDocModel.getAuthorId() != null) {
            EmployeeJpa author = findEmployeeJpa(incomingDocModel.getAuthorId(), "author");
            incomingDocJpa.setAuthor(author);
        }
        if (incomingDocModel.getRecipientId() != null) {
            EmployeeJpa recipient = findEmployeeJpa(incomingDocModel.getRecipientId(), "recipient");
            incomingDocJpa.setRecipient(recipient);
        }
        if (incomingDocModel.getSenderId() != null) {
            EmployeeJpa sender = findEmployeeJpa(incomingDocModel.getSenderId(), "sender");
            incomingDocJpa.setSender(sender);
        }
        incomingDocRepository.save(incomingDocJpa);
        return incomingDocJpa.getId();
    }

    public IncomingDocResponseDto read(UUID id) {
        Optional<IncomingDocJpa> incomingDocumentJpa = incomingDocRepository.findById(id);
        return incomingDocumentJpa.map(jpaResponseDtoMapper::toResponseDto)
                .orElseThrow(() -> new RuntimeException(("Incoming document with id %s not found".formatted(id))));
    }

    public List<IncomingDocResponseDto> readAll() {
        List<IncomingDocJpa> incomingDocJpas = (List<IncomingDocJpa>) incomingDocRepository.findAll();
        List<IncomingDocResponseDto> incomingDocResponseDtos = new ArrayList<>();
        incomingDocJpas.forEach(incDoc -> incomingDocResponseDtos.add(jpaResponseDtoMapper.toResponseDto(incDoc)));
        return incomingDocResponseDtos;
    }

    public void update(UUID id, IncomingDocModel incomingDocModel) {
        IncomingDocJpa existingIncomingDocJpa = incomingDocRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(("Incoming document with id %s not found".formatted(id))));
        modelJpaMapper.updateJpaFromModel(incomingDocModel, existingIncomingDocJpa);
        incomingDocRepository.save(existingIncomingDocJpa);
    }

    public void delete(UUID id) {
        incomingDocRepository.deleteById(id);
    }

    private EmployeeJpa findEmployeeJpa(UUID id, String employeeRole) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException(
                "%s with id %s not found".formatted(employeeRole, id)));
    }

    private void setDtoMissingFields(IncomingDocModel incomingDocModel) {
        incomingDocModel.setDocId(documentGenerator.generateId());
        String regNumber = documentGenerator.generateRegNumber();
        try {
            storage.add(regNumber);
        } catch (DocumentExistsException e) {
            throw new RuntimeException(e);
        }
        incomingDocModel.setRegNumber(regNumber);
        incomingDocModel.setRegDate(LocalDate.now());
        incomingDocModel.setOutgoingNumber(incomingDocumentGenerator.generateOutgoingNumber());
        incomingDocModel.setOutgoingRegDate(incomingDocumentGenerator.generateOutgoingRegDate());
    }
}
