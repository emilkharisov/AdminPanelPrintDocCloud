package ru.knitu.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.knitu.model.*;
import ru.knitu.repo.*;
import ru.knitu.service.UserService;

import java.time.LocalDateTime;
import java.util.Random;


@Controller
public class Init {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    TypeOfLocationRepository typeOfLocationRepository;
    @Autowired
    UniversityRepository universityRepository;
    @Autowired
    VendingMachineRepository vendingMachineRepository;

    @Autowired
    SellingRepo sellingRepo;

    @GetMapping("/init")
    public String init(){

        userService.createTechUser(true);
        userService.createTechUser(false);

        createCityList();
        createTypeOfLocationList();

        return "redirect:/getMainPage";

    }

    @GetMapping("/initSelling")
    public String initSelling(){

        // Test locale dates
        LocalDateTime localDateTime = LocalDateTime.of(2020, 2, 1, 18, 10);
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 2, 2, 18, 10);
        LocalDateTime localDateTime2 = LocalDateTime.of(2020, 2, 3, 18, 10);

        LocalDateTime localDateTime3 = LocalDateTime.of(2020, 3, 1, 18, 10);

        LocalDateTime localDateTime4 = LocalDateTime.of(2021, 2, 1, 18, 10);
        LocalDateTime localDateTime5 = LocalDateTime.of(2021, 3, 1, 18, 10);

        VendingMachine vendingMachineUnivercity = vendingMachineRepository.findVendingMachineById(3L);
        VendingMachine vendingMachineMoscow = vendingMachineRepository.findVendingMachineById(4L);
        VendingMachine vendingMachineUnivercity2 = vendingMachineRepository.findVendingMachineById(5L);

        // User - 1 Univer
        buildSelling(vendingMachineUnivercity, localDateTime, 100);
        buildSelling(vendingMachineUnivercity, localDateTime1, 171);
        buildSelling(vendingMachineUnivercity, localDateTime2, 5);

        buildSelling(vendingMachineUnivercity, localDateTime3, 6);

        buildSelling(vendingMachineUnivercity, localDateTime4, 7);
        buildSelling(vendingMachineUnivercity, localDateTime5, 8);

        // User - 2 Univer
        buildSelling(vendingMachineUnivercity2, localDateTime, 12);
        buildSelling(vendingMachineUnivercity2, localDateTime1, 21);
        buildSelling(vendingMachineUnivercity2, localDateTime2, 21);

        buildSelling(vendingMachineUnivercity2, localDateTime3, 42);

        buildSelling(vendingMachineUnivercity2, localDateTime4, 4);
        buildSelling(vendingMachineUnivercity2, localDateTime5, 121);

        // User - 2 Bussiness
        buildSelling(vendingMachineMoscow, localDateTime, 2);
        buildSelling(vendingMachineMoscow, localDateTime1, 1);
        buildSelling(vendingMachineMoscow, localDateTime2, 34);

        buildSelling(vendingMachineMoscow, localDateTime3, 43);

        buildSelling(vendingMachineMoscow, localDateTime4, 213);
        buildSelling(vendingMachineMoscow, localDateTime5, 12);


        return "redirect:/getMainPage";

    }

    private void buildSelling(VendingMachine vendingMachine, LocalDateTime localDateTime, int countOfPaper) {

        long sum = countOfPaper * 2;

        Selling selling = Selling.builder()
                    .vendingMachine(vendingMachine)
                    .time(localDateTime)
                    .countOfPaper(countOfPaper)
                    .sum(sum)
                    .year(localDateTime.getYear())
                    .month(localDateTime.getMonthValue())
                .build();

        sellingRepo.save(selling);

    }

    private void createTypeOfLocationList() {

        TypeOfLocation typeOfLocation = TypeOfLocation.builder()
                .id(1L)
                .type("Университет")
                .build();
        TypeOfLocation typeOfLocation2 = TypeOfLocation.builder()
                .id(2L)
                .type("Бизнес-центр")
                .build();
        TypeOfLocation typeOfLocation3 = TypeOfLocation.builder()
                .id(3L)
                .type("Другое")
                .build();

        typeOfLocationRepository.save(typeOfLocation);
        typeOfLocationRepository.save(typeOfLocation2);
        typeOfLocationRepository.save(typeOfLocation3);

    }

    private void createCityList(){

        City city = City.builder()
                .id(1L)
                .city("Казань")
                .build();
        City city2 = City.builder()
                .id(2L)
                .city("Москва")
                .build();
        City city3 = City.builder()
                .id(3L)
                .city("Альметьевск")
                .build();

        cityRepository.save(city);
        cityRepository.save(city2);
        cityRepository.save(city3);

        University university = University.builder()
                .id(1L)
                .city(city)
                .name("КНИТУ")
                .build();

        University university2 = University.builder()
                .id(2L)
                .city(city2)
                .name("МФТИ")
                .build();

        University university3 = University.builder()
                .id(3L)
                .city(city)
                .name("КФУ")
                .build();

        universityRepository.save(university);
        universityRepository.save(university2);
        universityRepository.save(university3);

    }

    @GetMapping("/initSelling/{vending}")
    public String makeSale(@PathVariable VendingMachine vending){

        int countOfPaper = 10;
        long sum = countOfPaper * 2;

        LocalDateTime localDateTime = LocalDateTime.now();

        Selling selling = Selling.builder()
                .vendingMachine(vending)
                .time(localDateTime)
                .countOfPaper(countOfPaper)
                .sum(sum)
                .year(localDateTime.getYear())
                .month(localDateTime.getMonthValue())
                .build();

        LocalDateTime localDateTime2 = LocalDateTime.now().minusDays(3);

        Selling selling2 = Selling.builder()
                .vendingMachine(vending)
                .time(localDateTime2)
                .countOfPaper(countOfPaper)
                .sum(sum)
                .year(localDateTime.getYear())
                .month(localDateTime.getMonthValue())
                .build();
        sellingRepo.save(selling);
        sellingRepo.save(selling2);


        return "redirect:/getMainPage";
    }

}
