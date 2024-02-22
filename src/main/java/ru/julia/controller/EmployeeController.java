/*
package ru.julia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.julia.orm.domain.JPAEmployee;
import ru.julia.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody JPAEmployee employee) {
        employeeService.create(employee);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<JPAEmployee> list() {
        return employeeService.readAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public JPAEmployee read(@PathVariable("id") String id) {
        return employeeService.read(id);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") String id, @RequestBody JPAEmployee employee) {
        employeeService.update(id, employee);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {
        employeeService.delete(id);
    }
}
*/
