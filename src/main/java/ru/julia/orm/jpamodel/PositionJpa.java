package ru.julia.orm.jpamodel;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "position")
@Data
@NoArgsConstructor
public class PositionJpa {
    @Id
    private UUID id;
    @Column(name = "position_id")
    private Integer positionId;
    private String name;
}
