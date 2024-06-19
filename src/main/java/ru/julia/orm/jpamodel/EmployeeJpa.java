package ru.julia.orm.jpamodel;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "employee")
public class EmployeeJpa {
    @Id
    private UUID id;
    private String surname;
    private String name;
    private String patronymic;
    private String photo;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "phone_number")
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentJpa departmentJpa;
    @ManyToOne
    @JoinColumn(name = "organization_id")
    private OrganizationJpa organizationJpa;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private PositionJpa positionJpa;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public DepartmentJpa getDepartmentJpa() {
        return departmentJpa;
    }

    public void setDepartmentJpa(DepartmentJpa departmentJPA) {
        this.departmentJpa = departmentJPA;
    }

    public OrganizationJpa getOrganizationJpa() {
        return organizationJpa;
    }

    public void setOrganizationJpa(OrganizationJpa organizationJPA) {
        this.organizationJpa = organizationJPA;
    }

    public PositionJpa getPositionJpa() {
        return positionJpa;
    }

    public void setPositionJpa(PositionJpa positionJPA) {
        this.positionJpa = positionJPA;
    }
}
