package ru.julia.orm.jpamodel;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "department")
public class JPADepartment {
    @Id
    private UUID id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "short_name")
    private String shortName;
    private String manager;
    @ManyToOne
    @JoinColumn(name = "organization_id")
    private JPAOrganization jpaOrganization;
    private String contactPhoneNumbers;

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

    public JPAOrganization getOrganization() {
        return jpaOrganization;
    }

    public void setOrganization(JPAOrganization JPAOrganization) {
        this.jpaOrganization = JPAOrganization;
    }

    public String getContactPhoneNumbers() {
        return contactPhoneNumbers;
    }

    public void setContactPhoneNumbers(String contactPhoneNumbers) {
        this.contactPhoneNumbers = contactPhoneNumbers;
    }
}
