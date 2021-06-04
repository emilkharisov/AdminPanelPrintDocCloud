package ru.knitu.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.knitu.controller.vendingMachine.VendingMachineController;
import ru.knitu.form.UserForm;
import ru.knitu.model.User;
import ru.knitu.repo.UserRepository;
import ru.knitu.service.UserService;
import ru.knitu.utils.ControllerUtility;
import ru.knitu.utils.UserUtility;

import javax.validation.Valid;

@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/getAddUserPage")
    public String getAddUserPage(Authentication authentication, ModelMap modelMap){

        LOGGER.info("UserController.getAddUserPage  USER = " + UserUtility.getUser(authentication).getLogin());

        ControllerUtility.setMainParams(modelMap, authentication);

        return "addUserPage";
    }

    @PostMapping("/getAddUserPage")
    public String addUser(@Valid UserForm userForm, BindingResult bindingResult, Authentication authentication, ModelMap modelMap){

        User user = userRepository.findUserByLogin(userForm.getLogin());

        if(user != null){
            modelMap.addAttribute("loginError", "Пользователь с таким логином - сущетсвует");
        }

        if (bindingResult.hasErrors()){

            modelMap.addAllAttributes(ControllerUtility.getErrors(bindingResult));

        } else {

            userService.createUser(userForm);
            LOGGER.info("UserController.addUser  USER = " + UserUtility.getUser(authentication).getLogin() + "  CREATED USER = " + userForm.getLogin());

        }

        ControllerUtility.setMainParams(modelMap, authentication);

        return "addUserPage";
    }


}
