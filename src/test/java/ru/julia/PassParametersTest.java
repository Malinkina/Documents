package ru.julia;

import org.junit.jupiter.api.Test;
import ru.julia.servicelayer.model.DepartmentModel;

public class PassParametersTest {
    @Test
    void pass() {
        DepartmentModel departmentModel = new DepartmentModel();
        departmentModel.setFullName("name");
        System.out.println(departmentModel.getFullName());
        change(departmentModel);
        System.out.println(departmentModel.getFullName());
        departmentModel.hashCode();
    }
    private void change(DepartmentModel model) {
       model.setFullName("newName");
    }
}
