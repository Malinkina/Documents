package ru.julia.controller;

import jakarta.validation.Valid;
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
    private OrganizationRequestDtoModelMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody OrganizationRequestDto organizationRequestDto) {
        organizationService.create(mapper.toModel(organizationRequestDto));
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
        organizationService.update(id, mapper.toModel(organizationRequestDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrg(@PathVariable("id") UUID id) {
        organizationService.delete(id);
    }
}
