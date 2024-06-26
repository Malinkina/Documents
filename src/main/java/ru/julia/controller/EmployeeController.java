package ru.julia.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.julia.controller.dto.request.EmployeeRequestDto;
import ru.julia.controller.dto.response.EmployeeResponseDto;
import ru.julia.mapper.employee.EmployeeRequestDtoModelMapper;
import ru.julia.servicelayer.service.EmployeeService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @Autowired
    private EmployeeRequestDtoModelMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('CREATE_EMPLOYEE')")
    public UUID create(@Valid @RequestBody EmployeeRequestDto employeeRequestDto) {
        return service.create(mapper.toModel(employeeRequestDto));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ_EMPLOYEE')")
    public List<EmployeeResponseDto> readAll() {
        return service.readAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ_EMPLOYEE')")
    public EmployeeResponseDto read(@PathVariable("id") UUID id) {
        return service.read(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('UPDATE_EMPLOYEE')")
    public void update(@PathVariable("id") UUID id, @RequestBody EmployeeRequestDto employeeRequestDto) {
        service.update(id, mapper.toModel(employeeRequestDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('DELETE_EMPLOYEE')")
    public void delete(@PathVariable("id") UUID id) {
        service.delete(id);
    }
}
