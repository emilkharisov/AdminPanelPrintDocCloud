package ru.knitu.controller.vendingMachine;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import ru.knitu.form.VendingMachineForm;
import ru.knitu.repo.CityRepository;
import ru.knitu.repo.TypeOfLocationRepository;
import ru.knitu.repo.UniversityRepository;
import ru.knitu.repo.UserRepository;
import ru.knitu.service.VendingMachineService;
import ru.knitu.utils.ControllerUtility;
import ru.knitu.utils.UserUtility;

import javax.validation.Valid;

@Controller
public class VendingMachineController {

    @Autowired
    CityRepository cityRepository;
    @Autowired
    TypeOfLocationRepository typeOfLocationRepository;
    @Autowired
    UniversityRepository universityRepository;
    @Autowired
    VendingMachineService vendingMachineService;
    @Autowired
    UserRepository userRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(VendingMachineController.class);

    @GetMapping("/addVendingMachine")
    public String getAddVendingMachinePage(Authentication authentication, ModelMap modelMap){

        LOGGER.info("VendingMachineController.getAddVendingMachinePage  USER = " + UserUtility.getUser(authentication).getLogin());
        setParams(authentication, modelMap);

        modelMap.addAttribute("users", userRepository.findAll());

        return "addVendingMachine";
    }

    @PostMapping("/addVendingMachine")
    public String addVendingMachinePage(@Valid VendingMachineForm vendingMachineForm, BindingResult bindingResult, Authentication authentication, ModelMap modelMap){

        if (bindingResult.hasErrors()){

            modelMap.addAllAttributes(ControllerUtility.getErrors(bindingResult));

        }
        else {

            vendingMachineService.createVendingMachine(vendingMachineForm, UserUtility.getUser(authentication));

        }

        setParams(authentication, modelMap);

        return "addVendingMachine";
    }

    private void setParams(Authentication authentication, ModelMap modelMap){

        modelMap.addAttribute("cityList", cityRepository.findAll());
        modelMap.addAttribute("typeList", typeOfLocationRepository.findAll());
        modelMap.addAttribute("universityList", universityRepository.findAll());

        modelMap.addAttribute("users", userRepository.findAll());


        ControllerUtility.setMainParams(modelMap, authentication);

    }


}
