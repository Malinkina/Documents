package ru.julia.servicelayer.service;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class OutgoingDocumentService {
    private final OutgoingDocRepository outgoingDocRepository;
    private final EmployeeRepository employeeRepository;
    private final OutgoingDocModelJpaMapper modelJpaMapper;
    private final OutgoingDocJpaResponseDtoMapper jpaResponseDtoMapper;
    private final DocumentInfoGenerator documentGenerator;
    private final RegNumbersStorage storage;
    private final CurrentEmployeeService employeeService;

    public UUID create(OutgoingDocModel outgoingDocModel) {
        if (outgoingDocModel.getId() == null) {
            setDTOMissingFields(outgoingDocModel);
        }
        OutgoingDocJpa outgoingDocJpa = modelJpaMapper.toJpa(outgoingDocModel);
        setEmployees(outgoingDocModel, outgoingDocJpa);
        outgoingDocRepository.save(outgoingDocJpa);
        return outgoingDocJpa.getId();
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

    private void setEmployees(OutgoingDocModel outgoingDocModel, OutgoingDocJpa outgoingDocJpa) {
        EmployeeJpa author = employeeService.getCurrentUser();
        EmployeeJpa recipient = findEmployeeJpa(outgoingDocModel.getRecipientId());
        outgoingDocJpa.setAuthor(author);
        outgoingDocJpa.setRecipient(recipient);
    }

    private EmployeeJpa findEmployeeJpa(UUID id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException(
                "Employee with id %s not found".formatted(id)));
    }
}
