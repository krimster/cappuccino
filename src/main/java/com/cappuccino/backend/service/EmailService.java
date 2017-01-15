package com.cappuccino.backend.service;

import com.cappuccino.web.domain.frontend.FeedbackPojo;
import org.springframework.mail.SimpleMailMessage;

/**
 * Contract for email service
 * Created by krime on 1/15/17.
 */
public interface EmailService {

    /**
     * Sends an email with the content in the Feedback Pojo
     * @param feedbackPojo The feedback Pojo
     */
    public void sendFeedbackEmail(FeedbackPojo feedbackPojo);


    /**
     * Sends an email with the content of the Simple Mail Message object
     * @param message The object containing the email content
     */
    public void sendGenericMessage(SimpleMailMessage message);
}
