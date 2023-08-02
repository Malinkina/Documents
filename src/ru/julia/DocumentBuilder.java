package ru.julia;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.stream.Collectors;
 public abstract class DocumentBuilder {
    int id;
    String name;
    String text;
    int regNumber;
    String regDate;
    String author;
    DocumentBuilder buildId() {
        this.id = (int) (Math.random() * 700);
        return this;
    }

    DocumentBuilder buildName() {
        this.name = randomString();
        return this;
    }

    DocumentBuilder buildText() {
        this.text = randomString();
        return this;
    }

    DocumentBuilder buildRegNumber() {
        this.regNumber = (int) (Math.random() * 100);
        return this;
    }

    DocumentBuilder buildRegDate() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        this.regDate = localDate.format(formatter);
        return this;
    }

    DocumentBuilder buildAuthor() {
        this.author = new InternalRepresentatives().randomRepresentative();
        return this;
    }

     public abstract Document build();

     String randomString() {
        String symbols = "abcdefghijklmnopqrstuvwxyz";
        return new Random().ints(7, 0, symbols.length())
                .mapToObj(symbols::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
