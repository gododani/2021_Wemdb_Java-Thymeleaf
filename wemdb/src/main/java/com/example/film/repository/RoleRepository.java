package com.example.film.repository;

import com.example.film.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findById(long Id);

}
