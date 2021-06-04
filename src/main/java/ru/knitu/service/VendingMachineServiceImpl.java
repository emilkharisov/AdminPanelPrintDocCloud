package ru.knitu.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.knitu.controller.vendingMachine.VendingMachineController;
import ru.knitu.form.VendingMachineForm;
import ru.knitu.model.*;
import ru.knitu.repo.*;
import ru.knitu.utils.UserUtility;

@Service
public class VendingMachineServiceImpl implements VendingMachineService {

    @Autowired
    VendingMachineRepository vendingMachineRepository;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    TypeOfLocationRepository typeOfLocationRepository;
    @Autowired
    UniversityRepository universityRepository;
    @Autowired
    UserRepository userRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(VendingMachineServiceImpl.class);


    @Override
    public void createVendingMachine(VendingMachineForm vendingMachineForm, User userSystem) {

        VendingMachine previousVendingMachine = vendingMachineRepository.findFirstByOrderByIdDesc();

        City city = cityRepository.findById(vendingMachineForm.getCity());
        TypeOfLocation typeOfLocation = typeOfLocationRepository.findById(vendingMachineForm.getTypeOfLocation());
        University university = universityRepository.findById(vendingMachineForm.getUniversity());

        long id = previousVendingMachine == null ? 1 : previousVendingMachine.getId() + 1;

        User user = userRepository.findById(vendingMachineForm.getOwner());

        VendingMachine vendingMachine = VendingMachine.builder()
                    .name("PrintDocCloud-Machine-V" + id)
                    .city(city)
                    .typeOfLocation(typeOfLocation)
                    .university(university)
                    .address(vendingMachineForm.getAddress())
                    .rentCoast(vendingMachineForm.getRentCoast())
                    .coastForPrint(vendingMachineForm.getCoastForPrint())
                    .user(user)
                .build();

        vendingMachineRepository.save(vendingMachine);

        LOGGER.info("VendingMachineServiceImpl.createVendingMachine  USER = " + userSystem.getLogin() + "  CREATED VENDING = " + vendingMachine.getName());

    }
}
