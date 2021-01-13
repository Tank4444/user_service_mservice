package ru.chuikov.mservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.chuikov.mservice.entity.Role;
import ru.chuikov.mservice.entity.Status;
import ru.chuikov.mservice.entity.User;
import ru.chuikov.mservice.repository.UserRepository;
import ru.chuikov.mservice.service.UserService;

import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public void addUser(User user) {
        //add check

        //username

        //email

        //els

        user.setRole(Role.USER);
        user.setStatus(Status.OPEN);
        user.setDataCreated(new Date());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.saveAndFlush(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username.toLowerCase());
    }

    @Override
    public User editUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
