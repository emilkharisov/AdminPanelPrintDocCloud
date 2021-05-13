package ru.knitu.utils;

import org.springframework.security.core.Authentication;
import org.springframework.ui.ModelMap;
import ru.knitu.model.Role;

public class ControllerUtility {

    public static void setMainParams(ModelMap modelMap, Authentication authentication){

        String login = UserUtility.getUser(authentication).getLogin();
        modelMap.addAttribute("login", login);

        modelMap.addAttribute("userPrintDoc", UserUtility.getUser(authentication));

        boolean isAdmin = UserUtility.getUser(authentication).getRole() == Role.ADMIN ? true : false;

        if(isAdmin){
            modelMap.addAttribute("isAdmin", isAdmin);
        }




    }

}
