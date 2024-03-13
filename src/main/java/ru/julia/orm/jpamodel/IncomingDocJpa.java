package ru.julia.orm.jpamodel;

import jakarta.persistence.*;

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
    private int outgoingNumber;
    @Column(name = "outgoing_reg_date")
    private String outgoingRegDate;

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

    public int getOutgoingNumber() {
        return outgoingNumber;
    }

    public void setOutgoingNumber(int outgoingNumber) {
        this.outgoingNumber = outgoingNumber;
    }

    public String getOutgoingRegDate() {
        return outgoingRegDate;
    }

    public void setOutgoingRegDate(String outgoingRegDate) {
        this.outgoingRegDate = outgoingRegDate;
    }
}
