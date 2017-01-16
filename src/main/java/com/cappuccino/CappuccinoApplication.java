package com.cappuccino;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by krime on 1/15/17.
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.cappuccino.backend.persistence.repositories")
public class CappuccinoApplication {
    public static void main(String[] args) {
        SpringApplication.run(CappuccinoApplication.class, args);
    }
}
