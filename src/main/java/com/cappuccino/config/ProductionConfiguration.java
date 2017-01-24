package com.cappuccino.config;

import com.cappuccino.backend.service.EmailService;
import com.cappuccino.backend.service.SmtpEmailService;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${stripe.prod.private.key}")
    private String stripeProdKey;


    @Bean
    public EmailService emailService() {
        return new SmtpEmailService();
    }


    @Bean
    public String stripeKey() {
        return stripeProdKey;
    }
}
