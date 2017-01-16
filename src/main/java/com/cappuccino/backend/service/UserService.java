package com.cappuccino.backend.service;

import com.cappuccino.backend.persistence.domain.backend.Plan;
import com.cappuccino.backend.persistence.domain.backend.User;
import com.cappuccino.backend.persistence.domain.backend.UserRole;
import com.cappuccino.backend.persistence.repositories.PlanRepository;
import com.cappuccino.backend.persistence.repositories.RoleRepository;
import com.cappuccino.backend.persistence.repositories.UserRepository;
import com.cappuccino.enums.PlansEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by krime on 1/16/17.
 */
@Service
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User createUser(User user, PlansEnum plansEnum, Set<UserRole> userRoles) {

        Plan plan = new Plan(plansEnum);
        // it's makes sure the plan exists in the database
        if (!planRepository.exists(plansEnum.getId())) {
            plan = planRepository.save(plan);
        }

        user.setPlan(plan);

        for (UserRole ur : userRoles) {
            roleRepository.save(ur.getRole());
        }

        user.getUserRoles().addAll(userRoles);

        user = userRepository.save(user);

        return user;
    }


}
