package com.cappuccino.config;

import com.cappuccino.backend.service.EmailService;
import com.cappuccino.backend.service.SmtpEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by krime on 1/15/17.
 */
@Configuration
@Profile("prod")
@PropertySource("file:///${user.home}/.cappuccino/application-prod.properties")
public class ProductionConfiguration {

    @Bean
    public EmailService emailService() {
        return new SmtpEmailService();
    }
}
