package ru.knitu.utils;

import org.springframework.security.core.Authentication;
import org.springframework.ui.ModelMap;
import ru.knitu.model.Role;
import ru.knitu.model.User;

public class ControllerUtility {

    public static void setMainParams(ModelMap modelMap, Authentication authentication){

        User user = UserUtility.getUser(authentication);

        String login = user.getLogin();
        modelMap.addAttribute("login", login);

        boolean isAdmin = UserUtility.getUser(authentication).getRole() == Role.ADMIN ? true : false;

        if(isAdmin){
            modelMap.addAttribute("isAdmin", isAdmin);
        }




    }

}
