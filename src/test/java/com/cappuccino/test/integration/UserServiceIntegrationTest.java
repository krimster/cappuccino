package com.cappuccino.test.integration;

import com.cappuccino.backend.persistence.domain.backend.Role;
import com.cappuccino.backend.persistence.domain.backend.User;
import com.cappuccino.backend.persistence.domain.backend.UserRole;
import com.cappuccino.backend.service.UserService;
import com.cappuccino.enums.PlansEnum;
import com.cappuccino.enums.RolesEnum;
import com.cappuccino.utils.UserUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

/**
 * UserService Integration Test
 * Created by krime on 1/16/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    public void testCreateUser() throws Exception {

        Set<UserRole> userRoles = new HashSet<>();
        User basicUser = UserUtils.createBasicUser();
        userRoles.add(new UserRole(basicUser, new Role(RolesEnum.BASIC)));

        User user = userService.createUser(basicUser, PlansEnum.BASIC, userRoles);
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());
    }
}
