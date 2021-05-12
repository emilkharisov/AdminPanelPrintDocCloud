package ru.knitu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.knitu.form.UserForm;
import ru.knitu.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getAddUserPage")
    public String getAddUserPage(Authentication authentication, ModelMap modelMap){


        modelMap.addAttribute("login", "login");

        return "addUserPage";
    }

    @PostMapping("/getAddUserPage")
    public String addUser(Authentication authentication, ModelMap modelMap, UserForm userForm){

        userService.createUser(userForm);

        modelMap.addAttribute("login", "login");

        return "addUserPage";
    }

    @GetMapping("/createTechUser")
    public String createTechUser(){


        userService.createTechUser();

        return "redirect:/login";
    }


}
