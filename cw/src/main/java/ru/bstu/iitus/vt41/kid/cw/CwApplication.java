package ru.bstu.iitus.vt41.kid.cw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("ru.bstu.iitus.vt41.kid.cw")
@EnableJpaRepositories
public class CwApplication {

    public static void main(String[] args) {
        SpringApplication.run(CwApplication.class, args);
    }

}