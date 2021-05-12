package ru.knitu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import ru.knitu.form.VendingMachineForm;
import ru.knitu.repo.CityRepository;
import ru.knitu.repo.TypeOfLocationRepository;
import ru.knitu.repo.UniversityRepository;
import ru.knitu.service.VendingMachineService;
import ru.knitu.utils.ControllerUtility;

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

    @GetMapping("/addVendingMachine")
    public String getAddVendingMachinePage(Authentication authentication, ModelMap modelMap){

        setParams(authentication, modelMap);

        return "addVendingMachine";
    }

    @PostMapping("/addVendingMachine")
    public String addVendingMachinePage(Authentication authentication, ModelMap modelMap, VendingMachineForm vendingMachineForm){

        setParams(authentication, modelMap);

        vendingMachineService.createVendingMachine(vendingMachineForm);

        return "addVendingMachine";
    }

    private void setParams(Authentication authentication, ModelMap modelMap){

        modelMap.addAttribute("cityList", cityRepository.findAll());
        modelMap.addAttribute("typeList", typeOfLocationRepository.findAll());
        modelMap.addAttribute("universityList", universityRepository.findAll());

        ControllerUtility.setLogin(modelMap, authentication);

    }


}
