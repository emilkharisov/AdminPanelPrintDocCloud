package ru.knitu.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.knitu.model.City;
import ru.knitu.model.TypeOfLocation;
import ru.knitu.model.University;
import ru.knitu.repo.CityRepository;
import ru.knitu.repo.TypeOfLocationRepository;
import ru.knitu.repo.UniversityRepository;
import ru.knitu.repo.UserRepository;
import ru.knitu.service.UserService;


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

    @GetMapping("/init")
    public String init(){

        userService.createTechUser(true);
        userService.createTechUser(false);

        createCityList();
        createTypeOfLocationList();

        return "redirect:/getMainPage";

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

}
