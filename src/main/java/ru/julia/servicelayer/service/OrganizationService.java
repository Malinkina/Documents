
package ru.julia.servicelayer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.dto.response.OrganizationResponseDTO;
import ru.julia.orm.jpamodel.OrganizationJPA;
import ru.julia.orm.repository.OrganizationRepository;
import ru.julia.mapper.OrganizationMapper;
import ru.julia.servicelayer.model.OrganizationModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private OrganizationMapper mapper;

    public void create(OrganizationModel organizationModel) {
        organizationRepository.save(mapper.modelToJpa(organizationModel));
    }

    public OrganizationResponseDTO read(UUID id) {
        Optional<OrganizationJPA> organizationJPA = organizationRepository.findById(id);
        return organizationJPA.map(organizationJpa -> mapper.jpaToResponseDto(organizationJpa))
                .orElseThrow(() -> new RuntimeException("Organization with id %s not found".formatted(id)));
    }

    public List<OrganizationResponseDTO> readAll() {
        List<OrganizationJPA> organizationsJPA = (List<OrganizationJPA>) organizationRepository.findAll();
        List<OrganizationResponseDTO> organizationResponseDTOS = new ArrayList<>();
        organizationsJPA.forEach(org -> organizationResponseDTOS.add(mapper.jpaToResponseDto(org)));
        return organizationResponseDTOS;
    }

    public void delete(UUID id) {
        organizationRepository.deleteById(id);
    }

}

