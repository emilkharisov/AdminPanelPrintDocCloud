package ru.knitu.controller.vendingMachine;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.knitu.utils.ControllerUtility;

@Controller
public class VendingMainPage {

    @GetMapping("/getVendingMain")
    public String getVendingMainPage(Authentication authentication, ModelMap modelMap){

        ControllerUtility.setMainParams(modelMap, authentication);

        return "vendingMainPage";
    }

}
