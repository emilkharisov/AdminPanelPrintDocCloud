package ru.knitu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.knitu.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login(Authentication authentication, HttpServletRequest request, ModelMap modelMap){

        if (authentication != null) {
            return "redirect:/getMainPage";
        }
        else {
            if (request.getParameterMap().containsKey("error")) {
                modelMap.addAttribute("error", true);
            }
        }
        return "login";

    }

}
