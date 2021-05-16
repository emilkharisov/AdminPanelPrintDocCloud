package ru.knitu.controller.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.knitu.model.Selling;
import ru.knitu.model.User;
import ru.knitu.model.VendingMachine;
import ru.knitu.repo.SellingRepo;
import ru.knitu.repo.VendingMachineRepository;
import ru.knitu.utils.ControllerUtility;
import ru.knitu.utils.UserUtility;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class VendingReportsController {

    @Autowired
    SellingRepo sellingRepo;
    @Autowired
    VendingMachineRepository vendingMachineRepository;


    @GetMapping("/vendingReportSelling")
    public String getAllReportSelling(Authentication authentication, ModelMap modelMap,@RequestParam(name = "vendingMachine") VendingMachine vendingMachine){

        ControllerUtility.setMainParams(modelMap, authentication);

        modelMap.addAttribute("sellings", sellingRepo.findAllByVendingMachine(vendingMachine));

        modelMap.addAttribute("vending" , vendingMachine);

        return "vendingSelling";
    }


    @PostMapping("/vendingReportSelling")
    public String search(Authentication authentication, ModelMap modelMap, @RequestParam Optional<Integer> year, @RequestParam Optional <Integer> month, @RequestParam(name = "vendingMachine") VendingMachine vendingMachine){

        if (year.isPresent()){

            if (month.isPresent()){

                String monthString = ControllerUtility.getMonthString(month.get());

                modelMap.addAttribute("sellings", sellingRepo.findAllByVendingMachineAndYearAndMonth(vendingMachine, year.get(), month.get()));
                modelMap.addAttribute("yearMonth", year.get() + " "  + monthString);


            }
            else {

                modelMap.addAttribute("sellings", sellingRepo.findAllByVendingMachineAndYear(vendingMachine, year.get()));
                modelMap.addAttribute("year", year.get());

            }

        }
        else {

            modelMap.addAttribute("sellings", sellingRepo.findAllByVendingMachine(vendingMachine));


        }

        ControllerUtility.setMainParams(modelMap, authentication);

        modelMap.addAttribute("vending" , vendingMachine);

        return "vendingSelling";
    }

}
