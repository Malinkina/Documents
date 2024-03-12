package ru.julia.servicelayer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.dto.response.IncomingDocumentResponseDTO;
import ru.julia.exception.DocumentExistsException;
import ru.julia.infogenerator.DocumentInfoGenerator;
import ru.julia.infogenerator.IncomingDocumentInfoGenerator;
import ru.julia.orm.jpamodel.EmployeeJPA;
import ru.julia.orm.jpamodel.IncomingDocumentJPA;
import ru.julia.orm.repository.EmployeeRepository;
import ru.julia.orm.repository.IncomingDocumentRepository;
import ru.julia.servicelayer.RegNumbersStorage;
import ru.julia.mapper.IncomingDocumentMapper;
import ru.julia.servicelayer.model.IncomingDocumentModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class IncomingDocumentService {
    @Autowired
    private IncomingDocumentRepository incomingDocumentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private IncomingDocumentMapper mapper;
    @Autowired
    private IncomingDocumentInfoGenerator incomingDocumentGenerator;
    @Autowired
    private DocumentInfoGenerator documentGenerator;

    public void create(IncomingDocumentModel incomingDocumentModel) {
        UUID recipientId = incomingDocumentModel.getRecipientId();
        EmployeeJPA recipient = employeeRepository.findById(recipientId)
                .orElseThrow(() -> new RuntimeException(
                        "Recipient with id %s not found".formatted(recipientId))
                );
        UUID senderId = incomingDocumentModel.getSenderId();
        EmployeeJPA sender = employeeRepository.findById(senderId)
                .orElseThrow(() -> new RuntimeException(
                        "Sender with id %s not found".formatted(senderId))
                );
        UUID authorId = incomingDocumentModel.getAuthorId();
        EmployeeJPA author = employeeRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException(
                        "Author with id %s not found".formatted(authorId))
                );
        if (incomingDocumentModel.getId() == 0) {
            setDTOMissingFields(incomingDocumentModel);
        }
        IncomingDocumentJPA incomingDocumentJPA = mapper.modelToJpa(incomingDocumentModel);
        incomingDocumentJPA.setSender(sender);
        incomingDocumentJPA.setRecipient(recipient);
        incomingDocumentJPA.setAuthor(author);
        incomingDocumentRepository.save(incomingDocumentJPA);
    }

    public IncomingDocumentResponseDTO read(UUID id) {
        Optional<IncomingDocumentJPA> incomingDocumentJPA = incomingDocumentRepository.findById(id);
        return incomingDocumentJPA.map(documentJpa -> mapper.jpaToResponseDTO(documentJpa))
                .orElseThrow(() -> new RuntimeException(("Incoming document with id %s not found".formatted(id))));
    }

    public List<IncomingDocumentResponseDTO> readAll() {
        List<IncomingDocumentJPA> incomingDocumentJPAs = (List<IncomingDocumentJPA>) incomingDocumentRepository.findAll();
        List<IncomingDocumentResponseDTO> incomingDocumentResponseDTOS = new ArrayList<>();
        incomingDocumentJPAs.forEach(incDoc -> incomingDocumentResponseDTOS.add(mapper.jpaToResponseDTO(incDoc)));
        return incomingDocumentResponseDTOS;
    }

    public void delete(UUID id) {
        incomingDocumentRepository.deleteById(id);
    }

    private void setDTOMissingFields(IncomingDocumentModel incomingDocumentModel) {
        incomingDocumentModel.setId(documentGenerator.generateId());
        String regNumber = documentGenerator.generateRegNumber();
        try {
            RegNumbersStorage.add(regNumber);
        } catch (DocumentExistsException e) {
            throw new RuntimeException(e);
        }
        incomingDocumentModel.setRegNumber(regNumber);
        incomingDocumentModel.setRegDate(LocalDate.now());
        incomingDocumentModel.setOutgoingNumber(incomingDocumentGenerator.generateOutgoingNumber());
        incomingDocumentModel.setOutgoingRegDate(incomingDocumentGenerator.generateRegDate());
    }
}
