package ru.julia.documents;

public abstract class Document {
    private int id;
    private String name;
    private String text;
    private int regNumber;
    private String regDate;
    private String author;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public int getRegNumber() {
        return regNumber;
    }

    public String getRegDate() {
        return regDate;
    }

    public String getAuthor() {
        return author;
    }

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




    /*public static class DocumentBuilder {
        Document document;

        public DocumentBuilder setId(int id) {
            document.id = id;
            return this;
        }

        public DocumentBuilder setName(String name) {
            document.name = name;
            return this;
        }

        public DocumentBuilder setText(String text) {
            document.text = text;
            return this;
        }

        public DocumentBuilder setRegNumber(int regNumber) {
            document.regNumber = regNumber;
            return this;
        }

        public DocumentBuilder setRegDate(String regDate) {
            document.regDate = regDate;
            return this;
        }

        public DocumentBuilder setAuthor(String author) {
            document.author = author;
            return this;
        }
        public Document build() {
            return document;
        }
    }*/
}

