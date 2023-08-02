package ru.julia;

public abstract class Document implements Comparable<Document> {
    int id;
    String name;
    String text;
    int regNumber;
    String regDate;
    String author;

    public Document(int id, String name, String text, int regNumber, String regDate, String author) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.regNumber = regNumber;
        this.regDate = regDate;
        this.author = author;
    }

    @Override
    public int compareTo(Document o) {
        return Integer.compare(regNumber, o.regNumber);
    }
}
