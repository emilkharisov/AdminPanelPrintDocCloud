package ru.knitu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.knitu.model.User;
import ru.knitu.model.VendingMachine;
import ru.knitu.repo.VendingMachineRepository;
import ru.knitu.utils.ControllerUtility;
import ru.knitu.utils.UserUtility;

import java.util.List;

@Controller
public class EditMainPage {

    @Autowired
    VendingMachineRepository vendingMachineRepository;

    @GetMapping("/editMainPage")
    public String getPage(Authentication authentication, ModelMap modelMap){

        User user = UserUtility.getUser(authentication);

        ControllerUtility.setMainParams(modelMap, authentication);

        List<VendingMachine> userMachineList = vendingMachineRepository.findAllByUser(user);
        modelMap.addAttribute("userMachineList", userMachineList);

        modelMap.addAttribute("currentUser", user);

        return "editMainPage";
    }

}
