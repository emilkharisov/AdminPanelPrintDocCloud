package ru.knitu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.knitu.model.VendingMachine;

public interface VendingMachineRepository extends JpaRepository<VendingMachine, Long> {

    VendingMachine findFirstByOrderByIdDesc();
}
