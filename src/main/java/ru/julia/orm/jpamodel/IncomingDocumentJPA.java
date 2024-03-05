package ru.julia.orm.jpamodel;

import jakarta.persistence.*;

@Entity
@Table(name = "incoming_document")
public class IncomingDocumentJPA extends DocumentJPA {
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private EmployeeJPA sender;
    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private EmployeeJPA recipient;
    @Column(name = "outgoing_number")
    private int outgoingNumber;
    @Column(name = "outgoing_reg_date")
    private String outgoingRegDate;

    public EmployeeJPA getSender() {
        return sender;
    }

    public void setSender(EmployeeJPA sender) {
        this.sender = sender;
    }

    public EmployeeJPA getRecipient() {
        return recipient;
    }

    public void setRecipient(EmployeeJPA recipient) {
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
