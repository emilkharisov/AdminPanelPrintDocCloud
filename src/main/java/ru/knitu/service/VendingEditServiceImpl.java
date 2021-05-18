package ru.knitu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.knitu.form.VendingMachineForm;
import ru.knitu.model.City;
import ru.knitu.model.TypeOfLocation;
import ru.knitu.model.University;
import ru.knitu.model.VendingMachine;
import ru.knitu.repo.*;

@Service
public class VendingEditServiceImpl implements EditService {

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
    public void edit(Object object, Long id) {

        VendingMachineForm vendingMachineForm = (VendingMachineForm) object;

        City city = cityRepository.findById(vendingMachineForm.getCity());
        TypeOfLocation typeOfLocation = typeOfLocationRepository.findById(vendingMachineForm.getTypeOfLocation());
        University university = universityRepository.findById(vendingMachineForm.getUniversity());

        VendingMachine vendingMachine = vendingMachineRepository.findVendingMachineById(id);

        if(vendingMachine.getUniversity() == null && university != null){
            vendingMachine.setTypeOfLocation(typeOfLocation);
            vendingMachine.setUniversity(university);
        }

        if(vendingMachine.getUniversity() != null && university == null){
            vendingMachine.setTypeOfLocation(typeOfLocation);
            vendingMachine.setUniversity(null);
        }

        vendingMachine.setCity(city);
        vendingMachine.setAddress(vendingMachineForm.getAddress());
        vendingMachine.setCoastForPrint(vendingMachineForm.getCoastForPrint());
        vendingMachine.setRentCoast(vendingMachineForm.getRentCoast());

        vendingMachineRepository.save(vendingMachine);

    }

}
