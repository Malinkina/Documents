package ru.julia.orm.jpamodel;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "employee")
public class JPAEmployee {
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
    private JPADepartment jpaDepartment;
    @ManyToOne
    @JoinColumn(name = "organization_id")
    private JPAOrganization jpaOrganization;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private JPAPosition jpaPosition;

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

    public JPADepartment getDepartment() {
        return jpaDepartment;
    }

    public void setDepartment(JPADepartment JPADepartment) {
        this.jpaDepartment = JPADepartment;
    }

    public JPAOrganization getOrganization() {
        return jpaOrganization;
    }

    public void setOrganization(JPAOrganization JPAOrganization) {
        this.jpaOrganization = JPAOrganization;
    }

    public JPAPosition getPosition() {
        return jpaPosition;
    }

    public void setPosition(JPAPosition JPAPosition) {
        this.jpaPosition = JPAPosition;
    }
}
