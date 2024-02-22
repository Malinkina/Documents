/*
package ru.julia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.julia.dto.OrganizationDTO;
import ru.julia.orm.domain.JPAOrganization;
import ru.julia.service.OrganizationService;
import ru.julia.service.mapper.OrganizationMapper;

import java.util.List;

@RestController
@RequestMapping("/organizations")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private OrganizationMapper mapper;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody OrganizationDTO organizationDTO) {
        organizationService.create(mapper.organizationDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<JPAOrganization> readAll() {
        return organizationService.readAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public JPAOrganization read(@PathVariable("id") String id) {
        return organizationService.read(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody JPAOrganization organization, @PathVariable("id") String id) {
        organizationService.update(id, organization);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrg(@PathVariable("id") String id) {
        organizationService.delete(id);
    }
}
*/
