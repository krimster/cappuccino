package com.cappuccino.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * Real implementation of an email service
 * Created by krime on 1/15/17.
 */
public class SmtpEmailService extends AbstractEmailService {

    /** The application logger */
    private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);

    @Autowired
    private MailSender mailSender;

    @Override
    public void sendGenericMessage(SimpleMailMessage message) {
        LOG.debug("Sending email for: {}", message);
        mailSender.send(message);
        LOG.info("Email sent.");

    }
}
