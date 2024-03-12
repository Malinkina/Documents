package ru.julia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.julia.dto.request.EmployeeRequestDTO;
import ru.julia.dto.response.EmployeeResponseDTO;
import ru.julia.mapper.EmployeeMapper;
import ru.julia.servicelayer.service.EmployeeService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @Autowired
    private EmployeeMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
        service.create(mapper.requestDtoToModel(employeeRequestDTO));
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeResponseDTO> readAll() {
        return service.readAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeResponseDTO read(@PathVariable("id") UUID id) {
        return service.read(id);
    }
    /*@PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") UUID id, @RequestBody EmployeeJPA employee) {
        service.update(id, employee);
    }*/
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") UUID id) {
        service.delete(id);
    }
}
