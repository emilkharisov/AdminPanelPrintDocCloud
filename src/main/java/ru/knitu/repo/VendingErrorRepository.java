package ru.knitu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.knitu.model.VendingError;

public interface VendingErrorRepository extends JpaRepository<VendingError, Long> {

}
