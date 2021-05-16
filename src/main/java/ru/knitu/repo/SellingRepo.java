package ru.knitu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.knitu.model.Selling;
import ru.knitu.model.VendingMachine;

import java.util.List;

public interface SellingRepo extends JpaRepository<Selling, Long> {

    List<Selling> findAllByCountOfPaperIsNotNullOrderByTime();

    List<Selling> findAllByYear(Integer year);
    List<Selling> findAllByYearAndMonth(Integer year, Integer month);


    List<Selling> findAllByVendingMachine(VendingMachine vendingMachine);
    List<Selling> findAllByVendingMachineAndYear(VendingMachine vendingMachine, Integer year);
    List<Selling> findAllByVendingMachineAndYearAndMonth(VendingMachine vendingMachine, Integer year, Integer month);


}
