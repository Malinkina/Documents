package ru.julia.orm.jpamodel;

import jakarta.persistence.*;

@Entity
@Table(name = "outgoing_document")
public class OutgoingDocJpa extends DocumentJpa {
    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private EmployeeJpa recipient;
    @Column(name = "delivery_type")
    private String deliveryType;

    public EmployeeJpa getRecipient() {
        return recipient;
    }

    public void setRecipient(EmployeeJpa recipient) {
        this.recipient = recipient;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }
}
