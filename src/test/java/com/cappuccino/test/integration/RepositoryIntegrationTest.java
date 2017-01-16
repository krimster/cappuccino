package com.cappuccino.test.integration;

import com.cappuccino.backend.persistence.domain.backend.Plan;
import com.cappuccino.backend.persistence.domain.backend.Role;
import com.cappuccino.backend.persistence.domain.backend.User;
import com.cappuccino.backend.persistence.domain.backend.UserRole;
import com.cappuccino.backend.persistence.repositories.PlanRepository;
import com.cappuccino.backend.persistence.repositories.RoleRepository;
import com.cappuccino.backend.persistence.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by krime on 1/16/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RepositoryIntegrationTest {

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    public static final int BASIC_PLAN_ID = 1;
    public static final int BASIC_ROLE_ID = 1;

    @Before
    public void init() {
        Assert.assertNotNull(planRepository);
        Assert.assertNotNull(roleRepository);
        Assert.assertNotNull(userRepository);
    }

    @Test
    public void testCreateNewPlan() throws Exception {
        Plan basicPlan = createBasicPlan();
        planRepository.save(basicPlan);

        Plan retrievedPlan = planRepository.findOne(BASIC_PLAN_ID);
        Assert.assertNotNull(retrievedPlan);
    }

    @Test
    public void testCreateNewRole() throws Exception {
        Role userRole = createBasicRole();
        roleRepository.save(userRole);

        Role retrievedRole = roleRepository.findOne(BASIC_ROLE_ID);
        Assert.assertNotNull(retrievedRole);
    }

    @Test
    public void createNewUser() throws Exception {

        // createa plan and save it
        Plan basicPlan = createBasicPlan();
        planRepository.save(basicPlan);

        // create a basic user and assign
        // it the newly created plan
        User basicUser = createBasicUser();
        basicUser.setPlan(basicPlan);

        Role basicRole = createBasicRole();
        Set<UserRole> userRoles = new HashSet<>();
        UserRole  userRole = new UserRole();
        userRole.setUser(basicUser);
        userRole.setRole(basicRole);
        userRoles.add(userRole);

        basicUser.getUserRoles().addAll(userRoles);

        for (UserRole ur : userRoles) {
            roleRepository.save(ur.getRole());
        }

        basicUser = userRepository.save(basicUser);
        User newlyCreatedUser = userRepository.findOne(basicUser.getId());
        Assert.assertNotNull(newlyCreatedUser);
        Assert.assertTrue(newlyCreatedUser.getId() != 0);
        Assert.assertNotNull(newlyCreatedUser.getPlan());
        Assert.assertNotNull(newlyCreatedUser.getPlan().getId());
        Set<UserRole> newlyCreatedUserRoles = newlyCreatedUser.getUserRoles();
        for (UserRole ur : newlyCreatedUserRoles) {
            Assert.assertNotNull(ur.getRole());
            Assert.assertNotNull(ur.getRole().getId());
        }
    }

    // ----------------------- Private methods
    private Plan createBasicPlan() {
        Plan plan = new Plan();
        plan.setId(BASIC_PLAN_ID);
        plan.setName("Basic");
        return plan;
    }

    private Role createBasicRole() {
        Role role = new Role();
        role.setId(BASIC_ROLE_ID);
        role.setName("ROLE_USER");
        return role;
    }

    private User createBasicUser() {

        User user = new User();
        user.setUsername("basicUser");
        user.setPassword("secret");
        user.setEmail("me@example.com");
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setPhoneNumber("123456789");
        user.setCountry("GB");
        user.setEnabled(true);
        user.setDescription("A basic user");
        user.setProfileImageUrl("http://www.blabla.com/basicuser");

        return user;
    }
}
