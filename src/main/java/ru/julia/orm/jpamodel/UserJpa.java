package ru.julia.orm.jpamodel;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class UserJpa {
    @Id
    private UUID id;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    @ManyToOne
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private RoleJpa role;
    @Column(name = "employee_id")
    private UUID employeeId;

    @PrePersist
    private void setPk() {
        id = UUID.randomUUID();
    }
}
