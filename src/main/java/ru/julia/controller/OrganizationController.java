package ru.julia.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.julia.controller.dto.request.OrganizationRequestDto;
import ru.julia.controller.dto.response.OrganizationResponseDto;
import ru.julia.mapper.organization.OrganizationRequestDtoModelMapper;
import ru.julia.servicelayer.service.OrganizationService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/organization")
public class OrganizationController {
    @Autowired
    private OrganizationService service;

    @Autowired
    private OrganizationRequestDtoModelMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('CREATE_ORGANIZATION')")
    public UUID create(@Valid @RequestBody OrganizationRequestDto organizationRequestDto) {
        return service.create(mapper.toModel(organizationRequestDto));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ_ORGANIZATION')")
    public List<OrganizationResponseDto> readAll() {
        return service.readAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ_ORGANIZATION')")
    public OrganizationResponseDto read(@PathVariable("id") UUID id) {
        return service.read(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('UPDATE_ORGANIZATION')")
    public void update(@PathVariable("id") UUID id, @RequestBody OrganizationRequestDto organizationRequestDto) {
        service.update(id, mapper.toModel(organizationRequestDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('DELETE_ORGANIZATION')")
    public void delete(@PathVariable("id") UUID id) {
        service.delete(id);
    }
}
