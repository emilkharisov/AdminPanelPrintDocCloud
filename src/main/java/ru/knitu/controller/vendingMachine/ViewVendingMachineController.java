package ru.knitu.controller.vendingMachine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.knitu.repo.VendingMachineRepository;
import ru.knitu.utils.ControllerUtility;

@Controller
public class ViewVendingMachineController {

    @Autowired
    VendingMachineRepository vendingMachineRepository;

    @GetMapping("/getAllVendingMachine")
    public String getPage(Authentication authentication, ModelMap modelMap){

        ControllerUtility.setMainParams(modelMap, authentication);

        modelMap.addAttribute("vendingList", vendingMachineRepository.findAll());

        return "allVendingMachinePage";
    }

}
