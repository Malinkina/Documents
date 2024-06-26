
package ru.julia.servicelayer.service;

import org.springframework.stereotype.Component;
import ru.julia.controller.dto.response.OrganizationResponseDto;
import ru.julia.mapper.organization.OrganizationJpaResponseDtoMapper;
import ru.julia.mapper.organization.OrganizationModelJpaMapper;
import ru.julia.orm.jpamodel.OrganizationJpa;
import ru.julia.orm.repository.OrganizationRepository;
import ru.julia.servicelayer.model.OrganizationModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class OrganizationService {
    private final OrganizationRepository organizationRepository;
    private final OrganizationModelJpaMapper organizationModelJpaMapper;
    private final OrganizationJpaResponseDtoMapper organizationJpaResponseDTOMapper;
    private final OrganizationModelJpaMapper modelJpaMapper;

    public OrganizationService(OrganizationRepository organizationRepository,
                               OrganizationModelJpaMapper organizationModelJpaMapper,
                               OrganizationJpaResponseDtoMapper organizationJpaResponseDTOMapper,
                               OrganizationModelJpaMapper modelJpaMapper) {
        this.organizationRepository = organizationRepository;
        this.organizationModelJpaMapper = organizationModelJpaMapper;
        this.organizationJpaResponseDTOMapper = organizationJpaResponseDTOMapper;
        this.modelJpaMapper = modelJpaMapper;
    }

    public UUID create(OrganizationModel organizationModel) {
        if (organizationModel.getId() == null) {
            organizationModel.setId(UUID.randomUUID());
        }
        OrganizationJpa organizationJpa = organizationModelJpaMapper.toJpa(organizationModel);
        organizationRepository.save(organizationJpa);
        return organizationJpa.getId();
    }

    public OrganizationResponseDto read(UUID id) {
        Optional<OrganizationJpa> organizationJpa = organizationRepository.findById(id);
        return organizationJpa.map(organizationJpaResponseDTOMapper::toResponseDto)
                .orElseThrow(() -> new RuntimeException("Organization with id %s not found".formatted(id)));
    }

    public List<OrganizationResponseDto> readAll() {
        List<OrganizationJpa> organizationsJpa = (List<OrganizationJpa>) organizationRepository.findAll();
        List<OrganizationResponseDto> organizationResponseDtos = new ArrayList<>();
        organizationsJpa.forEach(org -> organizationResponseDtos.add(organizationJpaResponseDTOMapper.toResponseDto(org)));
        return organizationResponseDtos;
    }

    public void update(UUID id, OrganizationModel organizationModel) {
        OrganizationJpa existingOrganization = organizationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Organization with id %s not found".formatted(id)));
        modelJpaMapper.updateJpaFromModel(organizationModel, existingOrganization);
        organizationRepository.save(existingOrganization);
    }

    public void delete(UUID id) {
        organizationRepository.deleteById(id);
    }

}

