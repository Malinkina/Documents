package ru.julia.servicelayer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.dto.response.OutgoingDocumentResponseDTO;
import ru.julia.exception.DocumentExistsException;
import ru.julia.infogenerator.DocumentInfoGenerator;
import ru.julia.mapper.OutgoingDocumentMapper;
import ru.julia.orm.jpamodel.EmployeeJPA;
import ru.julia.orm.jpamodel.OutgoingDocumentJPA;
import ru.julia.orm.repository.EmployeeRepository;
import ru.julia.orm.repository.OutgoingDocumentRepository;
import ru.julia.servicelayer.RegNumbersStorage;
import ru.julia.servicelayer.model.OutgoingDocumentModel;

import java.util.ArrayList;
import java.util.List;
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
    @Autowired
    private DocumentInfoGenerator documentGenerator;

    public void create(OutgoingDocumentModel outgoingDocumentModel) {
        UUID recipientId = outgoingDocumentModel.getRecipientId();
        EmployeeJPA recipient = employeeRepository.findById(recipientId)
                .orElseThrow(() -> new RuntimeException(
                        "Recipient with id " + recipientId + " not found")
                );
        UUID authorId = outgoingDocumentModel.getAuthorId();
        EmployeeJPA author = employeeRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException(
                        "Author with id " + authorId + " not found")
                );
        if (outgoingDocumentModel.getId() == 0) {
            setDTOMissingFields(outgoingDocumentModel);
        }
        OutgoingDocumentJPA outgoingDocumentJPA = mapper.modelToJpa(outgoingDocumentModel);
        outgoingDocumentJPA.setRecipient(recipient);
        outgoingDocumentJPA.setAuthor(author);
        outgoingDocumentRepository.save(outgoingDocumentJPA);
    }

    public OutgoingDocumentResponseDTO read(UUID id) {
        Optional<OutgoingDocumentJPA> outgoingDocumentJPA = outgoingDocumentRepository.findById(id);
        return outgoingDocumentJPA.map(documentJpa -> mapper.jpaToResponseDto(documentJpa))
                .orElseThrow(() -> new RuntimeException(("Outgoing document with id %s not found".formatted(id))));
    }

    public List<OutgoingDocumentResponseDTO> readAll() {
        List<OutgoingDocumentJPA> outgoingDocumentJPAs = (List<OutgoingDocumentJPA>) outgoingDocumentRepository.findAll();
        List<OutgoingDocumentResponseDTO> outgoingDocumentResponseDTOs = new ArrayList<>();
        outgoingDocumentJPAs.forEach(outgoingDoc -> outgoingDocumentResponseDTOs.add(mapper.jpaToResponseDto(outgoingDoc)));
        return outgoingDocumentResponseDTOs;
    }

    public void delete(UUID id) {
        outgoingDocumentRepository.deleteById(id);
    }

    private void setDTOMissingFields(OutgoingDocumentModel outgoingDocumentModel) {
        outgoingDocumentModel.setId(documentGenerator.generateId());
        String regNumber = documentGenerator.generateRegNumber();
        try {
            RegNumbersStorage.add(regNumber);
        } catch (DocumentExistsException e) {
            throw new RuntimeException(e);
        }
        outgoingDocumentModel.setRegNumber(regNumber);
        outgoingDocumentModel.setRegDate(documentGenerator.generateRegDate());
    }
}
