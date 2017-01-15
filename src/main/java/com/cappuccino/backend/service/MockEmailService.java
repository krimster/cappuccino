package com.cappuccino.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 * Created by krime on 1/15/17.
 */
@Service
public class MockEmailService extends AbstractEmailService {
   
    /** The application logger */
    private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);
   
    @Override
    public void sendGenericMessage(SimpleMailMessage message) {
        LOG.debug("Simulating an email service...");
        LOG.info(message.toString());
        LOG.debug("Email sent");
    }
}
