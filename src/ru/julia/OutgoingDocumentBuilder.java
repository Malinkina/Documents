package ru.julia;

public class OutgoingDocumentBuilder extends DocumentBuilder {
    String recipient;
    String deliveryType;

    private OutgoingDocumentBuilder buildRecipient() {
        this.recipient = new ExternalRepresentatives().randomRepresentative();
        return this;
    }

    private OutgoingDocumentBuilder buildDeliveryType() {
        DeliveryTypes[] deliveryTypes = DeliveryTypes.values();
        String deliveryType = deliveryTypes[(int) (Math.random() * 3)].toString();
        switch (deliveryType) {
            case "MAIL" -> this.deliveryType = "почтой";
            case "EMAIL" -> this.deliveryType = "емаилом";
            case "PIGEON" -> this.deliveryType = "голубем";
            case "UZEDO" -> this.deliveryType = "юзэдой";
        }
        return this;
    }
    public OutgoingDocument build() {
        OutgoingDocumentBuilder.super.buildId().buildName().buildText().buildRegNumber().buildRegDate().buildAuthor();
        buildRecipient();
        buildDeliveryType();
        return new OutgoingDocument(super.id, super.name, super.text, super.regNumber, super.regDate, super.author, recipient ,deliveryType);
    }
}
