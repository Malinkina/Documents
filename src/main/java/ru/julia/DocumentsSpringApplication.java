package ru.julia;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
@SpringBootApplication
@PropertySource("classpath:database.properties")
public class DocumentsSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(DocumentsSpringApplication.class, args);
    }
    @Bean
    public SpringLiquibase liquibase(@Autowired DataSourceConfiguration dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("changelog/db-changelog.xml");
        liquibase.setDataSource(dataSource.dataSource());
        return liquibase;
    }
}
