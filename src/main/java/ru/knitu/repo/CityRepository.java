package ru.knitu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.knitu.model.City;

public interface CityRepository extends JpaRepository<City, Long> {

    City findById(Long id);

}
