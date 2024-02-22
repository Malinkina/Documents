package ru.julia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.orm.jpamodel.JPAEmployee;
import ru.julia.orm.repository.EmployeeRepository;
import ru.julia.service.mapper.EmployeeMapper;
import ru.julia.service.modelforservice.EmployeeModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper mapper;

    public void create(EmployeeModel employeeModel) {
        employeeRepository.save(mapper.employeeModelToJpaEmployee(employeeModel));
    }

    public Optional<JPAEmployee> read(UUID id) {
        return employeeRepository.findById(id);
    }

    public List<JPAEmployee> readAll() {
        return (List<JPAEmployee>) employeeRepository.findAll();
    }

    public void delete(UUID id) {
        employeeRepository.deleteById(id);
    }
}

