package ru.julia.orm.jpamodel;

import jakarta.persistence.*;

@Entity
@Table(name = "outgoing_document")
public class OutgoingDocumentJPA extends DocumentJPA {
    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private EmployeeJPA recipient;
    @Column(name = "delivery_type")
    private String deliveryType;

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
