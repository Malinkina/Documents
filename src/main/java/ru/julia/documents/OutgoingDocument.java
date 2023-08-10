package ru.julia.documents;

public class OutgoingDocument extends Document {
    String recipient;
    String deliveryType;

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String toString() {
        return "Исходящий " + "№ " + "Акт_" + regNumber + " от " + regDate + ". " + name;
    }
}
