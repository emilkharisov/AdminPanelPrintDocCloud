package ru.knitu.utils;

import org.springframework.security.core.Authentication;
import org.springframework.ui.ModelMap;
import ru.knitu.model.Role;
import ru.knitu.model.User;

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

}
