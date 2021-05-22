package ru.knitu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.knitu.model.Selling;
import ru.knitu.model.User;
import ru.knitu.model.VendingMachine;
import ru.knitu.repo.SellingRepo;
import ru.knitu.repo.VendingMachineRepository;
import ru.knitu.utils.ControllerUtility;
import ru.knitu.utils.UserUtility;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainPageController {

    @Autowired
    SellingRepo sellingRepo;
    @Autowired
    VendingMachineRepository vendingMachineRepository;

    @GetMapping("/getMainPage")
    public String getMainPage(Authentication authentication, ModelMap modelMap){

        User user = UserUtility.getUser(authentication);
        List<VendingMachine> vendingMachineList = vendingMachineRepository.findAllByUser(user);

        List<Selling> sellingList = sellingRepo.findAllByVendingMachineIn(vendingMachineList);

        ControllerUtility.setMainParams(modelMap, authentication);

        modelMap.addAttribute("dayStonks", getStonks(sellingList,"day"));
        modelMap.addAttribute("monthStonks", getStonks(sellingList,"month"));
        modelMap.addAttribute("yearStonks", getStonks(sellingList,"year"));


        return "main";
    }


    private long getStonks( List<Selling> sellingList, String period){

        LocalDateTime now = LocalDateTime.now();

        switch (period){

            case "year":
                List<Selling> currentList = sellingList.stream()
                        .filter(selling -> selling.getYear() == now.getYear())
                        .collect(Collectors.toList());

                return currentList.stream().mapToLong(i -> i.getSum()).sum();

            case "month":
                List<Selling> currentList2 = sellingList.stream()
                        .filter(selling -> selling.getMonth() == now.getMonthValue())
                        .collect(Collectors.toList());

                return currentList2.stream().mapToLong(i -> i.getSum()).sum();

            case "day":
                List<Selling> currentList3 = sellingList.stream()
                        .filter(selling -> selling.getTime().getDayOfMonth() == now.getDayOfMonth())
                        .collect(Collectors.toList());

                return currentList3.stream().mapToLong(i -> i.getSum()).sum();
                default:
                    return 0;

        }
    }

}
