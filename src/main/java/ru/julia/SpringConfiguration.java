package ru.julia;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru.julia")
@PropertySource("classpath:database.properties")
public class SpringConfiguration {

}
