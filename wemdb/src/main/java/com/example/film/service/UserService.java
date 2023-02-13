package com.example.film.service;

import com.example.film.model.UnameAlreadyExistException;
import com.example.film.model.User;
import com.example.film.model.UserAlreadyExistException;

public interface UserService{
   void addUser(User user) throws UserAlreadyExistException, UnameAlreadyExistException;

   User findByEmail(String email);
   User findByUserName(String username);
   User findByUserId(Long id);
   void updateUser(User user) throws UnameAlreadyExistException, UserAlreadyExistException;
}



