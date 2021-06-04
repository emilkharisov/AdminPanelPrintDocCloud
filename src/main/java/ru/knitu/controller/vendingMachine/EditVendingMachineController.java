package ru.knitu.controller.vendingMachine;

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
import ru.knitu.form.VendingMachineForm;
import ru.knitu.model.VendingMachine;
import ru.knitu.repo.*;
import ru.knitu.service.EditService;
import ru.knitu.utils.ControllerUtility;
import ru.knitu.utils.UserUtility;


import javax.validation.Valid;


@Controller
public class EditVendingMachineController {

    @Autowired
    CityRepository cityRepository;
    @Autowired
    TypeOfLocationRepository typeOfLocationRepository;
    @Autowired
    UniversityRepository universityRepository;
    @Autowired
    VendingMachineRepository vendingMachineRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    @Qualifier("vendingEditServiceImpl")
    EditService editService;

    private static final Logger LOGGER = LoggerFactory.getLogger(EditVendingMachineController.class);

    @GetMapping("/editVendingMachine")
    public String getAddVendingMachinePage(Authentication authentication, ModelMap modelMap,  @RequestParam(name = "machineId") VendingMachine vendingMachine){

        setParams(authentication, modelMap);

        modelMap.addAttribute("vendingMachine", vendingMachine);

        LOGGER.info("EditVendingMachineController.getAddVendingMachinePage USER = " + UserUtility.getUser(authentication).getLogin());

        return "editVendingMachine";
    }

    @PostMapping("/editVendingMachine")
    public String edit (@Valid VendingMachineForm vendingMachineForm, BindingResult bindingResult, Authentication authentication, ModelMap modelMap, @RequestParam(name = "machineId") VendingMachine vendingMachine){

        if(bindingResult.hasErrors()){
            modelMap.addAllAttributes(ControllerUtility.getErrors(bindingResult));
        } else {
            editService.edit(vendingMachineForm, vendingMachine.getId());
            LOGGER.info("EditVendingMachineController.edit editMachine USER "+ vendingMachine.getName() +"  USER = " + UserUtility.getUser(authentication).getLogin());
        }

        setParams(authentication, modelMap);
        modelMap.addAttribute("vendingMachine", vendingMachine);

        return "editVendingMachine";
    }

    @GetMapping("/vendingList")
    public String getVendingListPage(Authentication authentication, ModelMap modelMap){

        ControllerUtility.setMainParams(modelMap, authentication);

        modelMap.addAttribute("vendingList", vendingMachineRepository.findAll());

        return "vendingList";
    }

    private void setParams(Authentication authentication, ModelMap modelMap){


        modelMap.addAttribute("cityList", cityRepository.findAll());
        modelMap.addAttribute("typeList", typeOfLocationRepository.findAll());
        modelMap.addAttribute("universityList", universityRepository.findAll());

        modelMap.addAttribute("users", userRepository.findAll());

        ControllerUtility.setMainParams(modelMap, authentication);

    }

}
