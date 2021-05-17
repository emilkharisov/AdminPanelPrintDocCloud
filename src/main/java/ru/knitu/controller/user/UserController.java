package ru.knitu.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.knitu.form.UserForm;
import ru.knitu.service.UserService;
import ru.knitu.utils.ControllerUtility;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getAddUserPage")
    public String getAddUserPage(Authentication authentication, ModelMap modelMap){


        ControllerUtility.setMainParams(modelMap, authentication);

        return "addUserPage";
    }

    @PostMapping("/getAddUserPage")
    public String addUser(Authentication authentication, ModelMap modelMap, UserForm userForm){

        userService.createUser(userForm);

        ControllerUtility.setMainParams(modelMap, authentication);

        return "addUserPage";
    }


}
