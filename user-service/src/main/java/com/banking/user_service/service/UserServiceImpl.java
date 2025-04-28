package com.banking.user_service.service;

import com.banking.user_service.entity.User;
import com.banking.user_service.exception.ResourceNotFoundException;
import com.banking.user_service.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{


    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {

        return Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id)));
    }

    @Override
    public User updateUser(Long id, User updatedUser)  {
        return userRepository.findById(id).map(user -> {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            return userRepository.save(user);
        }).orElseThrow(()-> new RuntimeException("User Not Found"));
    }


    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
