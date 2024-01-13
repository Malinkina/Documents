package ru.julia;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru.julia")
@PropertySource("classpath:database.properties")
@EnableAutoConfiguration
public class SpringConfiguration {

}
