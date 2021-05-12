package ru.knitu.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainPageController {

    @GetMapping("/getMainPage")
    public String getMainPage(Authentication authentication, ModelMap modelMap){


        modelMap.addAttribute("login", "login");
        return "main";
    }

    @PostMapping("/getMainPage")
    public String getMainPage(ModelMap modelMap){


        modelMap.addAttribute("login", "login");
        return "main";
    }

}
