
package ru.julia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.orm.jpamodel.JPAOrganization;
import ru.julia.orm.repository.OrganizationRepository;
import ru.julia.service.mapper.OrganizationMapper;
import ru.julia.service.modelforservice.OrganizationModel;

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
        organizationRepository.save(mapper.orgModelToOrgJpa(organizationModel));
    }

    public Optional<JPAOrganization> read(UUID id) {
        return organizationRepository.findById(id);
    }

    public List<JPAOrganization> readAll() {
        return (List<JPAOrganization>) organizationRepository.findAll();
    }

    public void delete(UUID id) {
        organizationRepository.deleteById(id);
    }

}

