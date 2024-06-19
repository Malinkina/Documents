package ru.julia.orm.jpamodel;

import jakarta.persistence.*;

import java.util.Objects;
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
    private String dateOfBirth;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeJpa that = (EmployeeJpa) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(surname, that.surname)) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(patronymic, that.patronymic)) return false;
        if (!Objects.equals(photo, that.photo)) return false;
        if (!Objects.equals(dateOfBirth, that.dateOfBirth)) return false;
        if (!Objects.equals(phoneNumber, that.phoneNumber)) return false;
        if (!Objects.equals(departmentJpa, that.departmentJpa))
            return false;
        if (!Objects.equals(organizationJpa, that.organizationJpa))
            return false;
        return Objects.equals(positionJpa, that.positionJpa);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (departmentJpa != null ? departmentJpa.hashCode() : 0);
        result = 31 * result + (organizationJpa != null ? organizationJpa.hashCode() : 0);
        result = 31 * result + (positionJpa != null ? positionJpa.hashCode() : 0);
        return result;
    }
}
