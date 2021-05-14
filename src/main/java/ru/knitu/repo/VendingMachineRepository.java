package ru.knitu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.knitu.model.TypeOfLocation;
import ru.knitu.model.User;
import ru.knitu.model.VendingMachine;

import java.util.List;

public interface VendingMachineRepository extends JpaRepository<VendingMachine, Long> {

    VendingMachine findFirstByOrderByIdDesc();

    List<VendingMachine> findAllByUniversityIsNotNull();

    List<VendingMachine> findAllByTypeOfLocation(TypeOfLocation typeOfLocation);

    List<VendingMachine> findAllByUser(User user);
}
