package ru.julia.orm.jpamodel;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "incoming_document")
public class IncomingDocumentJPA {
    @Id
    private UUID id;
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
    @OneToOne
    @JoinColumn(name = "document_id")
    private DocumentJPA documentJPA;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public DocumentJPA getDocument() {
        return documentJPA;
    }

    public void setDocument(DocumentJPA DocumentJPA) {
        this.documentJPA = DocumentJPA;
    }

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
