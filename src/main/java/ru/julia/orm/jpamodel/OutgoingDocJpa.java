package ru.julia.orm.jpamodel;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "outgoing_document")
@Data
@NoArgsConstructor
public class OutgoingDocJpa extends DocumentJpa {
    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private EmployeeJpa recipient;
    @Column(name = "delivery_type")
    private String deliveryType;
}
