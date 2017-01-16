package com.cappuccino.utils;

import com.cappuccino.backend.persistence.domain.backend.User;

/**
 * Created by krime on 1/16/17.
 */
public class UsersUtils {


    /**
     * Non instantiable
     */
    private UsersUtils() {
        throw new AssertionError("Non instantiable");
    }


    /**
     * Creates a user with basic attributes set
     * @return a user entity
     */
    public static User createBasicUser() {

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
