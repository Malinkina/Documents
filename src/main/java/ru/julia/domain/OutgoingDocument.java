package ru.julia.domain;

public class OutgoingDocument extends Document {
    private String recipientId;
    private String deliveryType;

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipient_id) {
        this.recipientId = recipient_id;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }
}
