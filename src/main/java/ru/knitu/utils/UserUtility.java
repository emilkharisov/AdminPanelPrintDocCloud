package ru.knitu.utils;

import org.springframework.security.core.Authentication;
import ru.knitu.model.User;
import ru.knitu.security.details.UserDetailsImpl;

public class UserUtility {

    public static User getUser(Authentication authentication){

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return userDetails.getUser();

    }

}
