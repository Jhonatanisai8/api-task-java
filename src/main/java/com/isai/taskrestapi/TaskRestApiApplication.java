package com.isai.taskrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TaskRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskRestApiApplication.class, args);
    }

}
