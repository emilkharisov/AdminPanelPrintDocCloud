package ru.knitu.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.knitu.form.UserForm;
import ru.knitu.service.UserService;
import ru.knitu.utils.ControllerUtility;

import javax.validation.Valid;

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
    public String addUser(@Valid UserForm userForm, BindingResult bindingResult, Authentication authentication, ModelMap modelMap){

        if (bindingResult.hasErrors()){

            modelMap.addAllAttributes(ControllerUtility.getErrors(bindingResult));

        } else {

            userService.createUser(userForm);

        }

        ControllerUtility.setMainParams(modelMap, authentication);

        return "addUserPage";
    }


}
