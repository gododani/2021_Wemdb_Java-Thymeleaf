package com.example.film.service;

import com.example.film.model.Role;
import com.example.film.model.UnameAlreadyExistException;
import com.example.film.model.User;
import com.example.film.model.UserAlreadyExistException;
import com.example.film.repository.RoleRepository;
import com.example.film.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Objects;


@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {
    public UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;
    private RoleService roleService;
    private SecurityService securityService;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
    @Autowired
    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }

    private String USER_ROLE = "USER";

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public void addUser(User c) throws UserAlreadyExistException, UnameAlreadyExistException {
        if (emailExist(c.getEmail())) {
            throw new UserAlreadyExistException("Már van felhasználó ezzel az emaillel! "
                    + c.getEmail());
        }
        if (findByUserName(c.getUserName())!=null){
            throw new UnameAlreadyExistException("Már van felhasználó ezzel a felhasználónévvel!");
        }
        Role userrole = roleRepository.findById(1);
        HashSet<Role> roleSet = new HashSet<>();
        roleSet.add(userrole);
        c.setPassword(passwordEncoder.encode(c.getPassword()));
        c.setRoles(roleSet);
        userRepository.save(c);

        log.info("Contact added: " + c.toString());
    }


    private boolean emailExist(String email) {
        return userRepository.findUserByEmail(email).isPresent();
    }


    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUserName(username);
    }


    public User findByUserId(Long id) {
        return userRepository.findByUserId(id);
    }
    @Override
    public void updateUser(User user) throws UnameAlreadyExistException, UserAlreadyExistException {
        String uname = securityService.findLoggedInUsername();
        User u = findByUserName(uname);
        if (emailExist(user.getEmail()) && !Objects.equals(user.getEmail(), u.getEmail())) {
            throw new UserAlreadyExistException("Már van felhasználó ezzel az emaillel! "
                    + user.getEmail());
        }
        if (findByUserName(user.getUserName())!=null && !Objects.equals(user.getUserName(), u.getUserName())){
            throw new UnameAlreadyExistException("Már van felhasználó ezzel a felhasználónévvel!");
        }
        user.setUserId(u.getUserId());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

}
