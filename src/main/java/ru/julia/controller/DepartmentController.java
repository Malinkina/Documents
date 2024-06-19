package ru.julia.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.julia.controller.dto.request.DepartmentRequestDto;
import ru.julia.controller.dto.response.DepartmentResponseDto;
import ru.julia.mapper.department.DepartmentRequestDtoModelMapper;
import ru.julia.servicelayer.service.DepartmentService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DepartmentRequestDtoModelMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('CREATE_DEPARTMENT')")
    public UUID create(@Valid @RequestBody DepartmentRequestDto departmentRequestDto) {
        return departmentService.create(mapper.toModel(departmentRequestDto));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ_DEPARTMENT')")
    public List<DepartmentResponseDto> readAll() {
        return departmentService.readAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ_DEPARTMENT')")
    public DepartmentResponseDto read(@PathVariable("id") UUID id) {
        return departmentService.read(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('UPDATE_DEPARTMENT')")
    public void update(@PathVariable("id") UUID id, @RequestBody DepartmentRequestDto departmentRequestDto) {
        departmentService.update(id, mapper.toModel(departmentRequestDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('DELETE_DEPARTMENT')")
    public void delete(@PathVariable("id") UUID id) {
        departmentService.delete(id);
    }
}
