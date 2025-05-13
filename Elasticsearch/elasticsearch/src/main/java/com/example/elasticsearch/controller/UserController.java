package com.example.elasticsearch.controller;

import com.example.elasticsearch.model.User;
import com.example.elasticsearch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/getAll")
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @GetMapping("/search")
    public List<User> searchByName(@RequestParam String name) {
        return userService.findByName(name);
    }

    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUserById(id);
    }
}
