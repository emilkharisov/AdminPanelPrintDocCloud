package ru.knitu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.knitu.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByLogin(String login);

    User findById(Long id);
}
