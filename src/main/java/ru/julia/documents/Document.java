package ru.julia.documents;

public abstract class Document implements Comparable<Document> {
    int id;
    String name;
    String text;
    int regNumber;
    String regDate;
    public String author;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setRegNumber(int regNumber) {
        this.regNumber = regNumber;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int compareTo(Document o) {
        return Integer.compare(regNumber, o.regNumber);
    }
}
