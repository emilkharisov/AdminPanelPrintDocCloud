package ru.knitu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.knitu.form.VendingMachineForm;
import ru.knitu.model.*;
import ru.knitu.repo.*;

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

    @Override
    public void createVendingMachine(VendingMachineForm vendingMachineForm) {

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

    }
}
