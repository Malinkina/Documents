package ru.julia;

public class IncomingDocument extends Document {
    String sender;
    String recipient;
    int outgoingNumber;
    String outgoingRegDate;

    public IncomingDocument(int id, String name, String text, int regNumber, String regDate, String author,
                            String sender, String recipient, int outgoingNumber, String outgoingRegDate) {
        super(id, name, text, regNumber, regDate, author);
        this.sender = sender;
        this.recipient = recipient;
        this.outgoingNumber = outgoingNumber;
        this.outgoingRegDate = outgoingRegDate;
    }

    @Override
    public String toString() {
        return "Входящий " + "№ " + "СЧФ_" + regNumber + " от " + regDate + ". " + name;
    }
}
