package ru.julia.orm.jpamodel;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "incoming_document")
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

    public EmployeeJpa getSender() {
        return sender;
    }

    public void setSender(EmployeeJpa sender) {
        this.sender = sender;
    }

    public EmployeeJpa getRecipient() {
        return recipient;
    }

    public void setRecipient(EmployeeJpa recipient) {
        this.recipient = recipient;
    }

    public Integer getOutgoingNumber() {
        return outgoingNumber;
    }

    public void setOutgoingNumber(Integer outgoingNumber) {
        this.outgoingNumber = outgoingNumber;
    }

    public LocalDate getOutgoingRegDate() {
        return outgoingRegDate;
    }

    public void setOutgoingRegDate(LocalDate outgoingRegDate) {
        this.outgoingRegDate = outgoingRegDate;
    }
}
