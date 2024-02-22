package ru.julia.orm.jpamodel;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "outgoing_document")
public class JPAOutgoingDocument {
    @Id
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private JPAEmployee recipient;
    @Column(name = "delivery_type")
    private String deliveryType;
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

    public JPAEmployee getRecipient() {
        return recipient;
    }

    public void setRecipient(JPAEmployee recipient) {
        this.recipient = recipient;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }
}
