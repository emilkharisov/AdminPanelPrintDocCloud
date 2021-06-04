package ru.knitu.utils;

import org.springframework.security.core.Authentication;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import ru.knitu.model.Role;
import ru.knitu.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ControllerUtility {

    public static void setMainParams(ModelMap modelMap, Authentication authentication){

        User user = UserUtility.getUser(authentication);

        String login = user.getLogin();
        modelMap.addAttribute("login", login);

        boolean isAdmin = UserUtility.getUser(authentication).getRole() == Role.ADMIN ? true : false;

        if(isAdmin){
            modelMap.addAttribute("isAdmin", isAdmin);
        }

    }

    public static Map<String, String> getErrors(BindingResult bindingResult) {
        Collector<FieldError, ?, Map<String, String>> collector = Collectors.toMap(
                fieldError -> fieldError.getField() + "Error",
                FieldError::getDefaultMessage
        );

        return bindingResult.getFieldErrors().stream().collect(collector);
    }

    public static String getMonthString(int month){

        String monthString;

        switch (month) {
            case 1:  monthString = "Январь";       break;
            case 2:  monthString = "Февраль";      break;
            case 3:  monthString = "Март";         break;
            case 4:  monthString = "Апрель";         break;
            case 5:  monthString = "Май";           break;
            case 6:  monthString = "Июнь";          break;
            case 7:  monthString = "Июль";          break;
            case 8:  monthString = "Август";        break;
            case 9:  monthString = "Сентябрь";     break;
            case 10: monthString = "Октябрь";       break;
            case 11: monthString = "Ноябрь";      break;
            case 12: monthString = "Декабрь";      break;
            default: monthString = "Invalid month"; break;
        }

        return monthString;
    }

    public static void addYears(ModelMap modelMap){

        LocalDateTime now = LocalDateTime.now();
        List<String> years = new ArrayList<String>();

        String currentYear = String.valueOf(now.getYear());
        String previousYear = String.valueOf(now.getYear() - 1);
        String prePreviousYear = String.valueOf(now.getYear() - 2);

        years.add(currentYear);
        years.add(previousYear);
        years.add(prePreviousYear);


        modelMap.addAttribute("years", years);
    }

}
