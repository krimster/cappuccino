package com.cappuccino.web.controllers;

import com.cappuccino.backend.service.EmailService;
import com.cappuccino.web.domain.frontend.FeedbackPojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by krime on 1/15/17.
 */
@Controller
public class ContactController {

    /** The application logger */
    private static final Logger LOG = LoggerFactory.getLogger(ContactController.class);

    /** The key which identifies the feedback paylod in the model. */
    public static final String FEEDBACK_MODEL_KEY = "feedback";

    /** The contact Us view name. */
    public static final String CONTACT_US_VIEW_NAME = "/contact/contact";

    @Autowired
    private EmailService emailService;

    @RequestMapping(value ="/contact", method = RequestMethod.GET)
    public String contactGet(ModelMap model) {
        FeedbackPojo feedbackPojo = new FeedbackPojo();
        model.addAttribute(ContactController.FEEDBACK_MODEL_KEY, feedbackPojo);
        return ContactController.CONTACT_US_VIEW_NAME;

    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public String contactPost(@ModelAttribute(FEEDBACK_MODEL_KEY) FeedbackPojo feedback) {
        LOG.debug("feedback POJO content: {}", feedback);
        emailService.sendFeedbackEmail(feedback);
        return ContactController.CONTACT_US_VIEW_NAME;
    }

}
