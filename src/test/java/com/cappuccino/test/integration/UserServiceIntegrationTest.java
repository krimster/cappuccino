package com.cappuccino.test.integration;

import com.cappuccino.backend.persistence.domain.backend.User;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * UserService Integration Test
 * Created by krime on 1/16/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceIntegrationTest extends AbstractServiceIntegrationTest {

    @Rule public TestName testName = new TestName();

    @Test
    public void testCreateUser() throws Exception {

        User user = createUser(testName);
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());
    }


//    @Test
//    public void testUpdateUserPassword() throws Exception {
//
//        User user = createUser(testName);
//        Assert.assertNotNull(user);
//        Assert.assertNotNull(user.getId());
//
//        String oldPassword = user.getPassword();
//
//        userService.updateUserPassword(user.getId(), UUID.randomUUID().toString());
//
//        user = userService.findUserByEmail(user.getEmail());
//        Assert.assertNotEquals(oldPassword, user.getPassword());
//
//    }

}
