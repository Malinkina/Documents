package ru.julia.orm.jpamodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "organization")
public class OrganizationJPA {
    @Id
    private UUID id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "short_name")
    private String shortName;
    private String manager;
    @Column(name = "phone_number")
    private String phoneNumbers;

    public UUID getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public String getManager() {
        return manager;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public static class OrganizationJPABuilder {
        private OrganizationJPA organizationJPA = new OrganizationJPA();

        public OrganizationJPABuilder id(UUID id) {
            organizationJPA.id = id;
            return this;
        }
        public OrganizationJPABuilder fullName(String fullName) {
            organizationJPA.fullName = fullName;
            return this;
        }
        public OrganizationJPABuilder shortName(String shortName) {
            organizationJPA.shortName = shortName;
            return this;
        }
        public OrganizationJPABuilder manager(String manager) {
            organizationJPA.manager = manager;
            return this;
        }
        public OrganizationJPABuilder phoneNumbers(String phoneNumbers) {
            organizationJPA.phoneNumbers = phoneNumbers;
            return this;
        }
        public OrganizationJPA build() {
            return organizationJPA;
        }
    }
}
