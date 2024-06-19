package ru.julia.orm.jpamodel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @JoinColumn(name = "position_id")
    private PositionJpa positionJpa;
    @ManyToOne
    @JoinColumn(name = "organization_id")
    private OrganizationJpa organizationJpa;
}
