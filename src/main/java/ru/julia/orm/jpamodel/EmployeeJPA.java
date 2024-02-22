package ru.julia.orm.jpamodel;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "employee")
public class EmployeeJPA {
    @Id
    private UUID id;
    private String surname;
    private String name;
    private String patronymic;
    private String photo;
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    @Column(name = "phone_number")
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentJPA departmentJPA;
    @ManyToOne
    @JoinColumn(name = "organization_id")
    private OrganizationJPA organizationJPA;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private PositionJPA positionJPA;

    public UUID getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPhoto() {
        return photo;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public DepartmentJPA getDepartmentJPA() {
        return departmentJPA;
    }

    public OrganizationJPA getOrganizationJPA() {
        return organizationJPA;
    }

    public PositionJPA getPositionJPA() {
        return positionJPA;
    }

    public void setDepartment(DepartmentJPA departmentJPA) {
        this.departmentJPA = departmentJPA;
    }

    public void setOrganization(OrganizationJPA organizationJPA) {
        this.organizationJPA = organizationJPA;
    }

    public void setPosition(PositionJPA positionJPA) {
        this.positionJPA = positionJPA;
    }

    public static class EmployeeJpaBuilder {
        private EmployeeJPA employeeJpa = new EmployeeJPA();

        public EmployeeJpaBuilder id(UUID id) {
            employeeJpa.id = id;
            return this;
        }
        public EmployeeJpaBuilder surname(String surname) {
            employeeJpa.surname = surname;
            return this;
        }
        public EmployeeJpaBuilder name(String name) {
            employeeJpa.name = name;
            return this;
        }
        public EmployeeJpaBuilder patronymic(String patronymic) {
            employeeJpa.patronymic = patronymic;
            return this;
        }
        public EmployeeJpaBuilder photo(String photo) {
            employeeJpa.photo = photo;
            return this;
        }
        public EmployeeJpaBuilder dateOfBirth(String dateOfBirth) {
            employeeJpa.dateOfBirth = dateOfBirth;
            return this;
        }
        public EmployeeJpaBuilder phoneNumber(String phoneNumber) {
            employeeJpa.phoneNumber = phoneNumber;
            return this;
        }
        public EmployeeJPA build() {
            return employeeJpa;
        }
    }
}
