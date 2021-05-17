package ru.knitu.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.knitu.form.UserForm;
import ru.knitu.model.Role;
import ru.knitu.model.State;
import ru.knitu.model.User;
import ru.knitu.repo.UserRepository;
import ru.knitu.service.EditService;
import ru.knitu.utils.ControllerUtility;

@Controller
public class EditUserController {


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

        ControllerUtility.setMainParams(modelMap, authentication);

        modelMap.addAttribute("currentUser", user);

        return "editUserPage";
    }

    @PostMapping("/getEditUserPage")
    public String editUser(Authentication authentication, ModelMap modelMap, @RequestParam(name = "userId") User user, UserForm userForm){


        editService.edit(userForm, user.getId());

        ControllerUtility.setMainParams(modelMap, authentication);
        modelMap.addAttribute("currentUser", user);

        return "editUserPage";
    }

    @GetMapping("/blockUser")
    public String blockUser(@RequestParam(name = "userId") User user) {

        user.setState(State.BANNED);
        userRepository.save(user);

        return "redirect:/getUserList";
    }

    @GetMapping("/unBlockUser")
    public String unBlockUser(@RequestParam(name = "userId") User user) {

        user.setState(State.ACTIVE);
        userRepository.save(user);

        return "redirect:/getUserList";
    }

}
