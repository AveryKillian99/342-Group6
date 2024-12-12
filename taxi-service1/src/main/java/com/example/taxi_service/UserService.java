package com.example.taxi_service.service;

import com.example.taxi_service.entity.User;
import com.example.taxi_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get a user by username
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Get a user by email
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Save or update a user, checking for duplicates by username or email
    public User saveUser(User user) {
        // Check if a user with the same username already exists
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("Username already exists.");
        }

        // Check if a user with the same email already exists
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("Email already exists.");
        }

        // Save the user if no duplicates found
        return userRepository.save(user);
    }

    // Update user details
    public User updateUser(Long id, User updatedUserDetails) {
        Optional<User> existingUserOpt = userRepository.findById(id);
        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();
            existingUser.setUsername(updatedUserDetails.getUsername());
            existingUser.setEmail(updatedUserDetails.getEmail());
            existingUser.setPassword(updatedUserDetails.getPassword());
            existingUser.setAccountStatus(updatedUserDetails.getAccountStatus());
            return userRepository.save(existingUser);
        }
        return null;  // Return null if the user with the provided ID doesn't exist
    }

    // Delete a user
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;  // Return false if the user wasn't found
    }

    // Remove duplicate users based on username or email
    @Transactional
    public void removeDuplicateUsers() {
        // Get all users
        List<User> allUsers = userRepository.findAll();

        // Find duplicates and delete
        Map<String, User> uniqueUsers = new HashMap<>();
        for (User user : allUsers) {
            if (uniqueUsers.containsKey(user.getUsername()) || uniqueUsers.containsKey(user.getEmail())) {
                // If duplicate username or email is found, delete the user
                userRepository.deleteById(user.getId());
            } else {
                uniqueUsers.put(user.getUsername(), user);
                uniqueUsers.put(user.getEmail(), user);
            }
        }
    }

    // Update user account status (e.g., ban or activate)
    public User updateUserStatus(Long id, String status) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setAccountStatus(status);
            return userRepository.save(existingUser);
        }
        return null;  // Could throw an exception if needed
    }
}
