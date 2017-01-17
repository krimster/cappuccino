package com.cappuccino;

import com.cappuccino.backend.service.I18nService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class CappuccinoApplicationTest {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private I18nService i18nService;

    @Test
    public void testMessageByLocaleService() throws Exception {
        String expectedResult = "Bootstrap starter template" ;
        String messageId = "index.main.callout";
        String actual = i18nService.getMessage(messageId);
        assertEquals("The actual and expected string don't match", expectedResult, actual);
    }
}