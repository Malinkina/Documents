package ru.julia.orm.jpamodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "organization")
@Data
@NoArgsConstructor
public class OrganizationJpa {
    @Id
    private UUID id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "short_name")
    private String shortName;
    private String manager;
    @Column(name = "phone_number")
    private String phoneNumbers;
}
