package ru.knitu.controller.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.knitu.model.User;
import ru.knitu.repo.VendingMachineRepository;
import ru.knitu.utils.ControllerUtility;
import ru.knitu.utils.UserUtility;

@Controller
public class ReportMainPageController {

    @Autowired
    VendingMachineRepository vendingMachineRepository;

    @GetMapping("/getReportMain")
    public String getReportMainPage(Authentication authentication, ModelMap modelMap){

        User user = UserUtility.getUser(authentication);

        ControllerUtility.setMainParams(modelMap, authentication);

        modelMap.addAttribute("userVendings", vendingMachineRepository.findAllByUser(user));
        return "reportsMainPage";
    }

}
