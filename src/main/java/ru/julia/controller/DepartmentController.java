package ru.julia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.julia.dto.request.DepartmentRequestDTO;
import ru.julia.dto.response.DepartmentResponseDTO;
import ru.julia.servicelayer.service.DepartmentService;
import ru.julia.mapper.DepartmentMapper;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DepartmentMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody DepartmentRequestDTO departmentRequestDTO) {
        departmentService.create(mapper.requestDtoToModel(departmentRequestDTO));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DepartmentResponseDTO> list() {
        return departmentService.readAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DepartmentResponseDTO read(@PathVariable("id") UUID id) {
        return departmentService.read(id);
    }

   /* @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") String id, @RequestBody DepartmentJPA department) {
        departmentService.update(id, department);
    }*/
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") UUID id) {
        departmentService.delete(id);
    }
}
