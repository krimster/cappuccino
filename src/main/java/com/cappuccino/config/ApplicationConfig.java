package com.cappuccino.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by krime on 1/16/17.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.cappuccino.backend.persistence.repositories")
@EntityScan(basePackages = "com.cappuccino.backend.persistence.domain.backend")
@EnableTransactionManagement
@PropertySource("file:///${user.home}/.cappuccino/application-common.properties")
public class ApplicationConfig {
}
