package com.cappuccino.test.integration;

import com.cappuccino.backend.persistence.domain.backend.Plan;
import com.cappuccino.backend.persistence.domain.backend.Role;
import com.cappuccino.backend.persistence.domain.backend.User;
import com.cappuccino.backend.persistence.domain.backend.UserRole;
import com.cappuccino.backend.persistence.repositories.PlanRepository;
import com.cappuccino.backend.persistence.repositories.RoleRepository;
import com.cappuccino.backend.persistence.repositories.UserRepository;
import com.cappuccino.enums.PlansEnum;
import com.cappuccino.enums.RolesEnum;
import com.cappuccino.utils.UsersUtils;
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

    @Before
    public void init() {
        Assert.assertNotNull(planRepository);
        Assert.assertNotNull(roleRepository);
        Assert.assertNotNull(userRepository);
    }

    @Test
    public void testCreateNewPlan() throws Exception {
        Plan basicPlan = createPlan(PlansEnum.BASIC);
        planRepository.save(basicPlan);

        Plan retrievedPlan = planRepository.findOne(PlansEnum.BASIC.getId());
        Assert.assertNotNull(retrievedPlan);
    }

    @Test
    public void testCreateNewRole() throws Exception {
        Role userRole = createRole(RolesEnum.BASIC);
        roleRepository.save(userRole);

        Role retrievedRole = roleRepository.findOne(RolesEnum.BASIC.getId());
        Assert.assertNotNull(retrievedRole);
    }

    @Test
    public void createNewUser() throws Exception {

        // createa plan and save it
        Plan basicPlan = createPlan(PlansEnum.BASIC);
        planRepository.save(basicPlan);

        // create a basic user and assign
        // it the newly created plan
        User basicUser = UsersUtils.createBasicUser();
        basicUser.setPlan(basicPlan);

        Role basicRole = createRole(RolesEnum.BASIC);
        Set<UserRole> userRoles = new HashSet<>();
        UserRole  userRole = new UserRole(basicUser, basicRole);
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
    private Plan createPlan(PlansEnum plan) {
       return new Plan(plan);
    }

    private Role createRole(RolesEnum role) {
        return new Role(role);
    }
}
