package ru.julia.servicelayer.service;

import org.springframework.stereotype.Component;
import ru.julia.controller.dto.response.OutgoingDocResponseDto;
import ru.julia.exception.DocumentExistsException;
import ru.julia.infogenerator.DocumentInfoGenerator;
import ru.julia.mapper.document.outgoing.OutgoingDocJpaResponseDtoMapper;
import ru.julia.mapper.document.outgoing.OutgoingDocModelJpaMapper;
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
    private final OutgoingDocRepository outgoingDocRepository;
    private final EmployeeRepository employeeRepository;
    private final OutgoingDocModelJpaMapper modelJpaMapper;
    private final OutgoingDocJpaResponseDtoMapper jpaResponseDtoMapper;
    private final DocumentInfoGenerator documentGenerator;
    private final RegNumbersStorage storage;

    public OutgoingDocumentService(OutgoingDocRepository outgoingDocRepository,
                                   EmployeeRepository employeeRepository,
                                   OutgoingDocModelJpaMapper modelJpaMapper,
                                   OutgoingDocJpaResponseDtoMapper jpaResponseDtoMapper,
                                   DocumentInfoGenerator documentGenerator,
                                   RegNumbersStorage storage) {
        this.outgoingDocRepository = outgoingDocRepository;
        this.employeeRepository = employeeRepository;
        this.modelJpaMapper = modelJpaMapper;
        this.jpaResponseDtoMapper = jpaResponseDtoMapper;
        this.documentGenerator = documentGenerator;
        this.storage = storage;
    }

    public void create(OutgoingDocModel outgoingDocModel) {
        if (outgoingDocModel.getId() == null) {
            setDTOMissingFields(outgoingDocModel);
        }
        OutgoingDocJpa outgoingDocJpa = modelJpaMapper.toJpa(outgoingDocModel);;
        if (outgoingDocModel.getAuthorId() != null) {
            EmployeeJpa author = findEmployeeJpa(outgoingDocModel.getAuthorId(), "author");
            outgoingDocJpa.setAuthor(author);
        }
        if (outgoingDocModel.getRecipientId() != null) {
            EmployeeJpa recipient = findEmployeeJpa(outgoingDocModel.getRecipientId(), "recipient");
            outgoingDocJpa.setRecipient(recipient);
        }
        outgoingDocRepository.save(outgoingDocJpa);
    }

    public OutgoingDocResponseDto read(UUID id) {
        Optional<OutgoingDocJpa> outgoingDocumentJPA = outgoingDocRepository.findById(id);
        return outgoingDocumentJPA.map(jpaResponseDtoMapper::toResponseDto)
                .orElseThrow(() -> new RuntimeException(("Outgoing document with id %s not found".formatted(id))));
    }

    public List<OutgoingDocResponseDto> readAll() {
        List<OutgoingDocJpa> outgoingDocJPAS = (List<OutgoingDocJpa>) outgoingDocRepository.findAll();
        List<OutgoingDocResponseDto> outgoingDocResponseDTOS = new ArrayList<>();
        outgoingDocJPAS.forEach(outgoingDoc -> outgoingDocResponseDTOS.add(jpaResponseDtoMapper.toResponseDto(outgoingDoc)));
        return outgoingDocResponseDTOS;
    }

    public void update(UUID id, OutgoingDocModel outgoingDocModel) {
        OutgoingDocJpa outgoingDocJpa = outgoingDocRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(("Incoming document with id %s not found".formatted(id))));
        modelJpaMapper.updateJpaFromModel(outgoingDocModel, outgoingDocJpa);
        outgoingDocRepository.save(outgoingDocJpa);
    }

    public void delete(UUID id) {
        outgoingDocRepository.deleteById(id);
    }

    private EmployeeJpa findEmployeeJpa(UUID id, String employeeRole) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException(
                "%s with id %s not found".formatted(employeeRole, id)));
    }

    private void setDTOMissingFields(OutgoingDocModel outgoingDocModel) {
        outgoingDocModel.setDocId(documentGenerator.generateId());
        String regNumber = documentGenerator.generateRegNumber();
        try {
            storage.add(regNumber);
        } catch (DocumentExistsException e) {
            throw new RuntimeException(e);
        }
        outgoingDocModel.setRegNumber(regNumber);
        outgoingDocModel.setRegDate(documentGenerator.generateRegDate());
    }
}
