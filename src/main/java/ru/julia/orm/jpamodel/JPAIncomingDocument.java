package ru.julia.orm.jpamodel;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "incoming_document")
public class JPAIncomingDocument {
    @Id
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private JPAEmployee sender;
    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private JPAEmployee recipient;
    @Column(name = "outgoing_number")
    private int outgoingNumber;
    @Column(name = "outgoing_reg_date")
    private String outgoingRegDate;
    @OneToOne
    @JoinColumn(name = "document_id")
    private JPADocument jpaDocument;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public JPADocument getDocument() {
        return jpaDocument;
    }

    public void setDocument(JPADocument JPADocument) {
        this.jpaDocument = JPADocument;
    }

    public JPAEmployee getSender() {
        return sender;
    }

    public void setSender(JPAEmployee sender) {
        this.sender = sender;
    }

    public JPAEmployee getRecipient() {
        return recipient;
    }

    public void setRecipient(JPAEmployee recipient) {
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
