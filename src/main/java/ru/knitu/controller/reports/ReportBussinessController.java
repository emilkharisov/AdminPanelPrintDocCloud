package ru.knitu.controller.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.knitu.model.Selling;
import ru.knitu.repo.SellingRepo;
import ru.knitu.utils.ControllerUtility;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class ReportBussinessController {

    @Autowired
    SellingRepo sellingRepo;

    @GetMapping("/bussinessReportSelling")
    public String getAllReportSelling(Authentication authentication, ModelMap modelMap){


        ControllerUtility.setMainParams(modelMap, authentication);

        modelMap.addAttribute("sellings", filterBussiness(sellingRepo.findAll()));

        return "bussinesSellingUniver";
    }

    @PostMapping("/bussinessReportSelling")
    public String search(Authentication authentication, ModelMap modelMap, @RequestParam Optional<Integer> year, @RequestParam Optional <Integer> month){

        if (year.isPresent()){

            if (month.isPresent()){

                String monthString = ControllerUtility.getMonthString(month.get());

                modelMap.addAttribute("sellings", filterBussiness(sellingRepo.findAllByYearAndMonth(year.get(), month.get())));
                modelMap.addAttribute("yearMonth", year.get() + " "  + monthString);


            }
            else {

                modelMap.addAttribute("sellings", filterBussiness(sellingRepo.findAllByYear(year.get())));
                modelMap.addAttribute("year", year.get());

            }

        }
        else {

            modelMap.addAttribute("sellings", filterBussiness(sellingRepo.findAll()));


        }

        ControllerUtility.setMainParams(modelMap, authentication);

        return "bussinesSellingUniver";
    }

    private List<Selling> filterBussiness(List<Selling> sellings){

        return  sellings.stream()
                .filter(selling -> selling.getVendingMachine().getTypeOfLocation().getType().equals("Бизнес-центр"))
                .collect(Collectors.toList());
    }




}
