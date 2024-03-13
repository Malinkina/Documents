package ru.julia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.julia.dto.request.OrganizationRequestDto;
import ru.julia.dto.response.OrganizationResponseDto;
import ru.julia.mapper.organization.OrganizationRequestDtoModelMapper;
import ru.julia.servicelayer.service.OrganizationService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/organizations")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private OrganizationRequestDtoModelMapper organizationRequestDTOModelMapper;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody OrganizationRequestDto organizationRequestDto) {
        organizationService.create(organizationRequestDTOModelMapper.toModel(organizationRequestDto));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrganizationResponseDto> readAll() {
        return organizationService.readAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrganizationResponseDto read(@PathVariable("id") UUID id) {
        return organizationService.read(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") UUID id, @RequestBody OrganizationRequestDto organizationRequestDto) {
        organizationService.update(id, organizationRequestDTOModelMapper.toModel(organizationRequestDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrg(@PathVariable("id") UUID id) {
        organizationService.delete(id);
    }
}
