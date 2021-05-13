package ru.knitu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.knitu.model.Selling;

public interface SellingRepo extends JpaRepository<Selling, Long> {
}
