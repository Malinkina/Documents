package ru.julia.domain;

public class IncomingDocument extends Document {
    private String senderId;
    private String recipientId;
    private int outgoingNumber;
    private String outgoingRegDate;


    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    public int getOutgoingNumber() {
        return outgoingNumber;
    }

    public void setOutgoingNumber(int outgoingNumber) {
        this.outgoingNumber = outgoingNumber;
    }

    public String getOutgoingRegDate() {
        return outgoingRegDate;
    }

    public void setOutgoingRegDate(String outgoingRegDate) {
        this.outgoingRegDate = outgoingRegDate;
    }

    @Override
    public String toString() {
        return super.toString() +
                "IncomingDocument{" +
                "senderId='" + senderId + '\'' +
                ", recipientId='" + recipientId + '\'' +
                ", outgoingNumber=" + outgoingNumber +
                ", outgoingRegDate='" + outgoingRegDate + '\'' +
                '}';
    }
}
