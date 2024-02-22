package ru.julia.orm.jpamodel;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "department")
public class DepartmentJPA {
    @Id
    private UUID id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "short_name")
    private String shortName;
    private String manager;
    @ManyToOne
    @JoinColumn(name = "organization_id")
    private OrganizationJPA organizationJPA;
    @Column(name = "phone_numbers")
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

    public OrganizationJPA getOrganizationJPA() {
        return organizationJPA;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setOrganization(OrganizationJPA organizationJPA) {
        this.organizationJPA = organizationJPA;
    }

    public static class DepartmentJpaBuilder {
        private DepartmentJPA departmentJPA = new DepartmentJPA();

        public DepartmentJpaBuilder id(UUID id) {
            departmentJPA.id = id;
            return this;
        }

        public DepartmentJpaBuilder fullName(String fullName) {
            departmentJPA.fullName = fullName;
            return this;
        }

        public DepartmentJpaBuilder shortName(String shortName) {
            departmentJPA.shortName = shortName;
            return this;
        }
        public DepartmentJpaBuilder manager(String manager) {
            departmentJPA.manager = manager;
            return this;
        }
        public DepartmentJpaBuilder phoneNumbers(String phoneNumbers) {
            departmentJPA.phoneNumbers = phoneNumbers;
            return this;
        }
        public DepartmentJPA build() {
            return departmentJPA;
        }
    }
}
