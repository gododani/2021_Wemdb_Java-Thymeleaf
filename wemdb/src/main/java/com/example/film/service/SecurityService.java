package com.example.film.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
