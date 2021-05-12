package ru.knitu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.knitu.form.VendingMachineForm;
import ru.knitu.model.City;
import ru.knitu.model.TypeOfLocation;
import ru.knitu.model.University;
import ru.knitu.model.VendingMachine;
import ru.knitu.repo.CityRepository;
import ru.knitu.repo.TypeOfLocationRepository;
import ru.knitu.repo.UniversityRepository;
import ru.knitu.repo.VendingMachineRepository;

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

    @Override
    public void createVendingMachine(VendingMachineForm vendingMachineForm) {

        VendingMachine previousVendingMachine = vendingMachineRepository.findFirstByOrderByIdDesc();

        City city = cityRepository.findById(vendingMachineForm.getCity());
        TypeOfLocation typeOfLocation = typeOfLocationRepository.findById(vendingMachineForm.getTypeOfLocation());
        University university = universityRepository.findById(vendingMachineForm.getUniversity());

        long id = previousVendingMachine == null ? 1 : previousVendingMachine.getId() + 1;

        VendingMachine vendingMachine = VendingMachine.builder()
                    .name("PrintDocCloud-Machine-V" + id)
                    .city(city)
                    .typeOfLocation(typeOfLocation)
                    .university(university)
                    .address(vendingMachineForm.getAddress())
                    .rentCoast(vendingMachineForm.getRentCoast())
                    .coastForPrint(vendingMachineForm.getCoastForPrint())
                .build();

        vendingMachineRepository.save(vendingMachine);

    }
}
