package ru.knitu.controller.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.knitu.repo.SellingRepo;
import ru.knitu.utils.ControllerUtility;

import java.util.Optional;

@Controller
public class AllReportsController {

    @Autowired
    SellingRepo sellingRepo;

    @GetMapping("/allReportSelling")
    public String getAllReportSelling(Authentication authentication, ModelMap modelMap){


        ControllerUtility.setMainParams(modelMap, authentication);

        modelMap.addAttribute("sellings", sellingRepo.findAll());

        return "reportSelling";
    }

    @PostMapping("/allReportSelling")
    public String search(Authentication authentication, ModelMap modelMap, @RequestParam Optional<Integer> year, @RequestParam Optional <Integer> month){

        if (year.isPresent()){

            if (month.isPresent()){

                modelMap.addAttribute("sellings", sellingRepo.findAllByYearAndMonth(year.get(), month.get()));

            }
            else {

                modelMap.addAttribute("sellings", sellingRepo.findAllByYear(year.get()));

            }

        }
        else {

            modelMap.addAttribute("sellings", sellingRepo.findAll());


        }

        ControllerUtility.setMainParams(modelMap, authentication);

        return "reportSelling";
    }

}
