package ru.julia.orm.jpamodel;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "department")
public class DepartmentJpa {
    @Id
    private UUID id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "short_name")
    private String shortName;
    private String manager;
    @ManyToOne
    @JoinColumn(name = "organization_id")
    private OrganizationJpa organizationJpa;
    @Column(name = "phone_numbers")
    private String phoneNumbers;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public OrganizationJpa getOrganizationJpa() {
        return organizationJpa;
    }

    public void setOrganizationJpa(OrganizationJpa organizationJPA) {
        this.organizationJpa = organizationJPA;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
