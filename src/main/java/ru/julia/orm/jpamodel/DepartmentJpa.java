package ru.julia.orm.jpamodel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Table(name = "department")
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentJpa {
    @Id
    private UUID id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "short_name")
    private String shortName;
    private String manager;
    @Column(name = "phone_numbers")
    private String phoneNumbers;
    @ManyToOne
    @JoinColumn(name = "organization_id")
    private OrganizationJpa organizationJpa;
}
