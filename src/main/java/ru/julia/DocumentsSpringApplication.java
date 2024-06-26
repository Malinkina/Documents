package ru.julia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:database.properties")
public class DocumentsSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(DocumentsSpringApplication.class, args);
    }
}
