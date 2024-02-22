package ru.julia.orm.jpamodel;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "outgoing_document")
public class OutgoingDocumentJPA {
    @Id
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private EmployeeJPA recipient;
    @Column(name = "delivery_type")
    private String deliveryType;
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

    public EmployeeJPA getRecipient() {
        return recipient;
    }

    public void setRecipient(EmployeeJPA recipient) {
        this.recipient = recipient;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }
}
