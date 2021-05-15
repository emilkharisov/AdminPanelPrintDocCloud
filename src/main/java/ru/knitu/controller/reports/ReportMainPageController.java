package ru.knitu.controller.reports;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.knitu.utils.ControllerUtility;

@Controller
public class ReportMainPageController {

    @GetMapping("/getReportMain")
    public String getReportMainPage(Authentication authentication, ModelMap modelMap){

        ControllerUtility.setMainParams(modelMap, authentication);

        return "reportsMainPage";
    }

}
