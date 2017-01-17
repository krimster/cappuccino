package com.cappuccino.utils;

import com.cappuccino.backend.persistence.domain.backend.User;
import com.cappuccino.web.controllers.ForgotMyPasswordController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by krime on 1/16/17.
 */
public class UserUtils {


    /**
     * Non instantiable
     */
    private UserUtils() {
        throw new AssertionError("Non instantiable");
    }


    /**
     * Creates a user with basic attributes set
     * @Param username The username
     * @Param email The email.
     * @return a user entity
     */
    public static User createBasicUser(String username, String email) {

        User user = new User();
        user.setUsername(username);
        user.setPassword("secret");
        user.setEmail(email);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setPhoneNumber("123456789");
        user.setCountry("GB");
        user.setEnabled(true);
        user.setDescription("A basic user");
        user.setProfileImageUrl("http://www.blabla.com/basicuser");

        return user;
    }

    public static String createPasswordResetUrl(HttpServletRequest request, long userId, String token) {

        String passwordResetUrl =

                request.getScheme() +
                        "://" +
                        request.getServerName() +
                        ":" +
                        request.getServerPort() +
                        request.getContextPath() +
                        ForgotMyPasswordController.CHANGE_PASSWORD_PATH +
                        "?id=" +
                        userId +
                        "&token=" +
                        token;

        return passwordResetUrl;
    }
}
