package ru.julia.orm.jpamodel;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.julia.servicelayer.model.Privilege;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "role")
@NoArgsConstructor
public class RoleJpa {
    @Id
    private UUID id;
    @NotNull
    private String code;
    @ElementCollection
    @CollectionTable(name = "role_privilege",
            joinColumns = @JoinColumn(name = "role_id"))
    @Column(name = "privilege")
    private List<Privilege> privileges;

    @PrePersist
    private void setPk() {
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return code;
    }
}