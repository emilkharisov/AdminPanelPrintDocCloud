package ru.knitu.controller.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.knitu.model.Selling;
import ru.knitu.model.User;
import ru.knitu.repo.SellingRepo;
import ru.knitu.utils.ControllerUtility;
import ru.knitu.utils.UserUtility;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class UserReportsController {

    @Autowired
    SellingRepo sellingRepo;

    @GetMapping("/userAllReportSelling")
    public String getAllReportSelling(Authentication authentication, ModelMap modelMap){

        User user = UserUtility.getUser(authentication);

        ControllerUtility.setMainParams(modelMap, authentication);

        modelMap.addAttribute("sellings", filterUser(sellingRepo.findAll(), user));

        String userName = String.format("%s %s", user.getTypeOfLegalEntity(), user.getNameOfLegalEntity());
        modelMap.addAttribute("name", userName);

        return "userReportSelling";
    }

    @PostMapping("/userAllReportSelling")
    public String search(Authentication authentication, ModelMap modelMap, @RequestParam Optional<Integer> year, @RequestParam Optional <Integer> month){

        User user = UserUtility.getUser(authentication);

        if (year.isPresent()){

            if (month.isPresent()){

                String monthString = ControllerUtility.getMonthString(month.get());

                modelMap.addAttribute("sellings", filterUser(sellingRepo.findAllByYearAndMonth(year.get(), month.get()), user));
                modelMap.addAttribute("yearMonth", year.get() + " "  + monthString);


            }
            else {

                modelMap.addAttribute("sellings", filterUser(sellingRepo.findAllByYear(year.get()), user));
                modelMap.addAttribute("year", year.get());

            }

        }
        else {

            modelMap.addAttribute("sellings", filterUser(sellingRepo.findAll(), user));


        }

        ControllerUtility.setMainParams(modelMap, authentication);

        String userName = String.format("%s %s", user.getTypeOfLegalEntity(), user.getNameOfLegalEntity());
        modelMap.addAttribute("name", userName);

        return "userReportSelling";
    }

    private List<Selling> filterUser(List<Selling> sellings, User user){

        return  sellings.stream()
                .filter(selling -> selling.getVendingMachine().getUser() != user)
                .collect(Collectors.toList());
    }


}
