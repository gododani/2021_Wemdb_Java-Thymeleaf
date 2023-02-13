package com.example.film.service;

import com.example.film.model.Role;
import com.example.film.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    Role findById(long Id){
        return roleRepository.findById(Id);
    }
}
