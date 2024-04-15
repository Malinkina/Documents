package ru.julia.orm.jpamodel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "incoming_document")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncomingDocJpa extends DocumentJpa {
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private EmployeeJpa sender;
    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private EmployeeJpa recipient;
    @Column(name = "outgoing_number")
    private Integer outgoingNumber;
    @Column(name = "outgoing_reg_date")
    private LocalDate outgoingRegDate;
}
