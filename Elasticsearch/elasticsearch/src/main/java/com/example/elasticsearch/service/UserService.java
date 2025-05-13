package com.example.elasticsearch.service;

import com.example.elasticsearch.model.User;
import com.example.elasticsearch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User saveUser(User user) {
        return userRepository.save(user);
    }


    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }


    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }


    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }


    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }
}
