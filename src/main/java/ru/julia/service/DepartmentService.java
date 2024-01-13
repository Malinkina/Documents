package ru.julia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.dao.DepartmentDAO;
import ru.julia.domain.Department;

import java.util.List;

@Component
public class DepartmentService {
    @Autowired
    private DepartmentDAO departmentDAO;

    public void create(Department department) {
        departmentDAO.create(department);
    }

    public Department read(String id) {
        return departmentDAO.read(id);
    }

    public List<Department> readAll() {
        return departmentDAO.readAll();
    }

    public void update(String id, Department department) {
        departmentDAO.update(id, department);
    }

    public void delete(String id) {
        departmentDAO.delete(id);
    }
}
