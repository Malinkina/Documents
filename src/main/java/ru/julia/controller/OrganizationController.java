package ru.julia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.julia.domain.Organization;
import ru.julia.service.OrganizationService;

import java.util.List;

@RestController
@RequestMapping("/organizations")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Organization organization) {
        organizationService.create(organization);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Organization> readAll() {
        return organizationService.readAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Organization read(@PathVariable("id") String id) {
        return organizationService.read(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Organization organization, @PathVariable("id") String id) {
        organizationService.update(id, organization);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrg(@PathVariable("id") String id) {
        organizationService.delete(id);
    }
}
