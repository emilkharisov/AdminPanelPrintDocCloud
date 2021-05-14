package ru.knitu.controller.vendingMachine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.knitu.model.TypeOfLocation;
import ru.knitu.model.User;
import ru.knitu.repo.TypeOfLocationRepository;
import ru.knitu.repo.VendingMachineRepository;
import ru.knitu.utils.ControllerUtility;
import ru.knitu.utils.UserUtility;

@Controller
public class ViewVendingMachineController {

    @Autowired
    VendingMachineRepository vendingMachineRepository;
    @Autowired
    TypeOfLocationRepository typeOfLocationRepository;

    @GetMapping("/getAllVendingMachine")
    public String getPage(Authentication authentication, ModelMap modelMap){

        ControllerUtility.setMainParams(modelMap, authentication);

        modelMap.addAttribute("vendingList", vendingMachineRepository.findAll());

        return "allVendingMachinePage";
    }

    @GetMapping("/getUniversityVendingMachine")
    public String getUniversityVendingMachinePage(Authentication authentication, ModelMap modelMap){

        ControllerUtility.setMainParams(modelMap, authentication);

        modelMap.addAttribute("vendingList", vendingMachineRepository.findAllByUniversityIsNotNull());

        return "universityVendingMachinePage";
    }

    @GetMapping("/getBussisnessVendingMachine")
    public String getBussisnessVendingMachinePage(Authentication authentication, ModelMap modelMap){

        ControllerUtility.setMainParams(modelMap, authentication);

        TypeOfLocation bussinessPlace = typeOfLocationRepository.findByType("Бизнес центр");

        modelMap.addAttribute("vendingList", vendingMachineRepository.findAllByTypeOfLocation(bussinessPlace));

        return "bussisnessVendingMachinePage";
    }

    @GetMapping("/getUserVendingMachine")
    public String getUserVendingMachinePage(Authentication authentication, ModelMap modelMap){

        User user = UserUtility.getUser(authentication);
        String userName = String.format("%s %s", user.getTypeOfLegalEntity(), user.getNameOfLegalEntity());
        modelMap.addAttribute("name", userName);

        ControllerUtility.setMainParams(modelMap, authentication);

        modelMap.addAttribute("vendingList", vendingMachineRepository.findAllByUser(user));

        return "userVendingMachinePage";
    }

}
