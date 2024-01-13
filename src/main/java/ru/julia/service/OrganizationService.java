package ru.julia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.dao.OrganizationDAO;
import ru.julia.domain.Organization;

import java.util.List;

@Component
public class OrganizationService {
    @Autowired
    private OrganizationDAO organizationDAO;

    public void create(Organization organization) {
        organizationDAO.create(organization);
    }

    public Organization read(String id) {
        return organizationDAO.read(id);
    }

    public List<Organization> readAll() {
        return organizationDAO.readAll();
    }

    public void update(String id, Organization organization) {
        organizationDAO.update(id, organization);
    }

    public void delete(String id) {
        organizationDAO.delete(id);
    }
}
