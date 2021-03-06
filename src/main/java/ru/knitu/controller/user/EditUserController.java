package ru.knitu.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.knitu.controller.vendingMachine.VendingMachineController;
import ru.knitu.form.UserForm;
import ru.knitu.model.Role;
import ru.knitu.model.State;
import ru.knitu.model.User;
import ru.knitu.repo.UserRepository;
import ru.knitu.service.EditService;
import ru.knitu.utils.ControllerUtility;
import ru.knitu.utils.UserUtility;

import javax.validation.Valid;

@Controller
public class EditUserController {


    private static final Logger LOGGER = LoggerFactory.getLogger(EditUserController.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    @Qualifier("editUserService")
    EditService editService;

    @GetMapping("/getUserList")
    public String getUserListPage(Authentication authentication, ModelMap modelMap){

        ControllerUtility.setMainParams(modelMap, authentication);

        modelMap.addAttribute("userList", userRepository.findAll());
        modelMap.addAttribute("roleAdmin", Role.ADMIN);
        modelMap.addAttribute("stateBanned", State.BANNED);

        return "userList";
    }

    @GetMapping("/getEditUserPage")
    public String getEditUserPage(Authentication authentication, ModelMap modelMap, @RequestParam(name = "userId") User user){

        LOGGER.info("EditUserController.getEditUserPage USER = " + UserUtility.getUser(authentication).getLogin());

        ControllerUtility.setMainParams(modelMap, authentication);

        modelMap.addAttribute("currentUser", user);

        return "editUserPage";
    }

    @PostMapping("/getEditUserPage")
    public String editUser(@Valid UserForm userForm, BindingResult bindingResult, Authentication authentication, ModelMap modelMap, @RequestParam(name = "userId") User user){

        if(bindingResult.hasErrors()){
            modelMap.addAllAttributes(ControllerUtility.getErrors(bindingResult));

        } else {
            editService.edit(userForm, user.getId());
            LOGGER.info("EditUserController.editUser editUser USER "+ user.getLogin() +"  USER = " + UserUtility.getUser(authentication).getLogin());

        }

        ControllerUtility.setMainParams(modelMap, authentication);
        modelMap.addAttribute("currentUser", user);

        return "editUserPage";
    }

    @GetMapping("/blockUser")
    public String blockUser(@RequestParam(name = "userId") User user, Authentication authentication) {

        user.setState(State.BANNED);
        userRepository.save(user);

        LOGGER.info("EditUserController.blockUser block USER "+ user.getLogin() +"  USER = " + UserUtility.getUser(authentication).getLogin());

        return "redirect:/getUserList";
    }

    @GetMapping("/unBlockUser")
    public String unBlockUser(@RequestParam(name = "userId") User user, Authentication authentication) {

        user.setState(State.ACTIVE);
        userRepository.save(user);

        LOGGER.info("EditUserController.unBlockUser unBlock USER "+ user.getLogin() +"  USER = " + UserUtility.getUser(authentication).getLogin());

        return "redirect:/getUserList";
    }

}
