package com.example.taxi_service.controller;

import com.example.taxi_service.entity.User;
import com.example.taxi_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    // Endpoint to get a user by username
    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        logger.info("Fetching user with username: {}", username);

        User user = userService.getUserByUsername(username);
        if (user != null) {
            logger.info("User found: {}", user);
            return ResponseEntity.ok(user);
        } else {
            logger.warn("User not found with username: {}", username);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Endpoint to get all users (for SysAdmin use-case)
    @GetMapping
    public ResponseEntity<Iterable<User>> getAllUsers() {
        logger.info("Fetching all users");
        Iterable<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Endpoint to create a new user (SysAdmin can create a user)
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        logger.info("Creating a new user: {}", user.getUsername());
        User createdUser = userService.saveUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // Endpoint to update a user (SysAdmin can update user details)
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUserDetails) {
        logger.info("Updating user with ID: {}", id);
        User updatedUser = userService.updateUser(id, updatedUserDetails);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Endpoint to update user status (SysAdmin can ban or activate a user)
    @PutMapping("/{id}/status/{status}")
    public ResponseEntity<User> updateUserStatus(@PathVariable Long id, @PathVariable String status) {
        logger.info("Updating status for user with ID: {} to status: {}", id, status);
        User updatedUser = userService.updateUserStatus(id, status);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Endpoint to delete a user (SysAdmin can delete a user)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        logger.info("Deleting user with ID: {}", id);
        boolean isDeleted = userService.deleteUser(id);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
