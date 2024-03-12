package ru.julia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.julia.dto.request.OrganizationRequestDTO;
import ru.julia.dto.response.OrganizationResponseDTO;
import ru.julia.servicelayer.service.OrganizationService;
import ru.julia.mapper.OrganizationMapper;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/organizations")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private OrganizationMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody OrganizationRequestDTO organizationRequestDTO) {
        organizationService.create(mapper.requestDtoToModel(organizationRequestDTO));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrganizationResponseDTO> readAll() {
        return organizationService.readAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrganizationResponseDTO read(@PathVariable("id") UUID id) {
        return organizationService.read(id);
    }

    /*@PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody OrganizationJPA organization, @PathVariable("id") String id) {
        organizationService.update(id, organization);
    }*/

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrg(@PathVariable("id") UUID id) {
        organizationService.delete(id);
    }
}
