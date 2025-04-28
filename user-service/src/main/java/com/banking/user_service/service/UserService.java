package com.banking.user_service.service;

import com.banking.user_service.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

    User createUser (User user);

    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}
