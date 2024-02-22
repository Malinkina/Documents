/*
package ru.julia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.julia.orm.domain.JPADepartment;
import ru.julia.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    public DepartmentService departmentService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody JPADepartment department) {
        departmentService.create(department);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<JPADepartment> list() {
        return departmentService.readAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public JPADepartment read(@PathVariable("id") String id) {
        return departmentService.read(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") String id, @RequestBody JPADepartment department) {
        departmentService.update(id, department);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {
        departmentService.delete(id);
    }
}
*/
