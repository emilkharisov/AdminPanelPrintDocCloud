package ru.knitu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.knitu.model.User;
import ru.knitu.repo.UserRepository;
import ru.knitu.service.ResetPasswordService;

@Controller
public class ResetPasswordController {

    @Autowired
    ResetPasswordService resetPasswordService;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/getResetPassword")
    public String getResetPasswordPage(){
        return "renewPassword";
    }

    @PostMapping("/getResetPassword")
    public String resetPassword(ModelMap modelMap, @RequestParam String login){

        User user = userRepository.findUserByLogin(login);

        if(user == null){
            modelMap.addAttribute("renewPasswordError", "Пользователя с таким логином - не сущетсвует");
        } else {

            resetPasswordService.resetPassword(user);
            return "redirect:/login";

        }

        return "renewPassword";
    }

}
