package ru.knitu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.knitu.model.City;
import ru.knitu.model.TypeOfLocation;

public interface TypeOfLocationRepository extends JpaRepository<TypeOfLocation, Long> {

    TypeOfLocation findById(Long id);

}
