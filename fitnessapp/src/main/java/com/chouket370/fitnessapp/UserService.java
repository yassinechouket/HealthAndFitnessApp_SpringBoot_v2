package com.chouket370.fitnessapp;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();

    }
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalStateException(id + " not found"));
    }
    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }
    public User save(User user) {
        return userRepository.save(user);
    }
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }



}
