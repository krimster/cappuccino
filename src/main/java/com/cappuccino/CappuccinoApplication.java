package com.cappuccino;

import com.cappuccino.backend.persistence.domain.backend.Role;
import com.cappuccino.backend.persistence.domain.backend.User;
import com.cappuccino.backend.persistence.domain.backend.UserRole;
import com.cappuccino.backend.service.UserService;
import com.cappuccino.enums.PlansEnum;
import com.cappuccino.enums.RolesEnum;
import com.cappuccino.utils.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by krime on 1/15/17.
 */
@SpringBootApplication
public class CappuccinoApplication implements CommandLineRunner {

    /** The application logger */
    private static final Logger LOG = LoggerFactory.getLogger(CappuccinoApplication.class);

    @Autowired
    private UserService userService;


    public static void main(String[] args) {
        SpringApplication.run(CappuccinoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        String username = "proUser";
        String email = "proUser@cappuccino.com";

        User user = UserUtils.createBasicUser(username, email);
        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(new UserRole(user, new Role(RolesEnum.PRO)));
        LOG.debug("Creating user with username {}", user.getUsername());
        userService.createUser(user, PlansEnum.PRO, userRoles);
        LOG.info("User {} created", user.getUsername());


    }
}
