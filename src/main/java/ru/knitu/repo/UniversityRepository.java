package ru.knitu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.knitu.model.University;

public interface UniversityRepository extends JpaRepository<University, Long> {

    University findById(Long id);

}
