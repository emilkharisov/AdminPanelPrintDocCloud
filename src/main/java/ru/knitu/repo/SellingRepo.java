package ru.knitu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.knitu.model.Selling;

import java.util.List;

public interface SellingRepo extends JpaRepository<Selling, Long> {

    List<Selling> findAllByCountOfPaperIsNotNullOrderByTime();

    List<Selling> findAllByYear(Integer year);
    List<Selling> findAllByYearAndMonth(Integer year, Integer month);

}
