package com.cappuccino.config;

import com.cappuccino.backend.service.EmailService;
import com.cappuccino.backend.service.MockEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by krime on 1/15/17.
 */
@Configuration
@Profile("dev")
@PropertySource("file:///${user.home}/.cappuccino/application-dev.properties")
public class DevelopmentConfig {

    @Bean
    public EmailService emailService() {
        return new MockEmailService();
    }
}
