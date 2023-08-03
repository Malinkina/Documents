package ru.julia.documents;

import ru.julia.documents.Document;

public class OutgoingDocument extends Document {
    String recipient;
    String deliveryType;

    public OutgoingDocument(int id, String name, String text, int regNumber, String regDate, String author, String recipient, String deliveryType) {
        super(id, name, text, regNumber, regDate, author);
        this.recipient = recipient;
        this.deliveryType = deliveryType;
    }

    public String toString() {
        return "Исходящий " + "№ " + "Акт_" + regNumber + " от " + regDate + ". " + name;
    }
}
