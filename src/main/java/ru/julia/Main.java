package ru.julia;

import org.springframework.boot.SpringApplication;

public class Main {
    public static void main(String[] args) throws DocumentExistsException {
        /*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        context.getBean(Starter.class).start();*/
        SpringApplication.run(SpringConfiguration.class, args);
    }
}
