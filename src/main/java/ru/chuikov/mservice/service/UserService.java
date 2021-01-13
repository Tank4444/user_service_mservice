package ru.chuikov.mservice.service;

import ru.chuikov.mservice.entity.User;

import java.util.Optional;

public interface UserService {
    void addUser(User user);
    Optional<User> getUserById(Long id);
    Optional<User> getUserByUsername(String username);
    User editUser(User user);
    void deleteUser(Long id);
}
