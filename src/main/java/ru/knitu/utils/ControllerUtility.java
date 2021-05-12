package ru.knitu.utils;

import org.springframework.security.core.Authentication;
import org.springframework.ui.ModelMap;

public class ControllerUtility {

    public static void setLogin(ModelMap modelMap, Authentication authentication){

        String login = UserUtility.getUser(authentication).getLogin();
        modelMap.addAttribute("login", login);

    }

}
