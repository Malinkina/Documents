package ru.julia.documents;

public class IncomingDocument extends Document {
    String sender;
    String recipient;
    int outgoingNumber;
    String outgoingRegDate;

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setOutgoingNumber(int outgoingNumber) {
        this.outgoingNumber = outgoingNumber;
    }

    public void setOutgoingRegDate(String outgoingRegDate) {
        this.outgoingRegDate = outgoingRegDate;
    }

    @Override
    public String toString() {
        return "Входящий " + "№ " + "СЧФ_" + regNumber + " от " + regDate + ". " + name;
    }
}
