package ru.julia.orm.jpamodel;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "document")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
public abstract class DocumentJpa {
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name = "document_id")
    private Integer docId;
    private String name;
    private String text;
    @Column(name = "reg_number")
    private String regNumber;
    @Column(name = "reg_date")
    private LocalDate regDate;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private EmployeeJpa author;

    @PrePersist
    private void setPk(){
        id = UUID.randomUUID();
    }
}
