package com.example.film.repository;

import com.example.film.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
    User findByEmail(String email);
    User findByUserName(String username);
    User findByUserId(Long id);
}
