package com.theverdict.theverdict.service;

import com.theverdict.theverdict.model.User;
import com.theverdict.theverdict.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get a single user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Update user (full update)
    public Optional<User> updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword()); // Should be hashed if changed
            existingUser.setRole(updatedUser.getRole());
            return userRepository.save(existingUser);
        });
    }

    // Partial update (PATCH)
    public Optional<User> partialUpdateUser(Long id, User partialUser) {
        return userRepository.findById(id).map(existingUser -> {
            if (partialUser.getEmail() != null) {
                existingUser.setEmail(partialUser.getEmail());
            }
            if (partialUser.getPassword() != null) {
                existingUser.setPassword(partialUser.getPassword()); // Should be hashed if changed
            }
            if (partialUser.getRole() != null) {
                existingUser.setRole(partialUser.getRole());
            }
            return userRepository.save(existingUser);
        });
    }

    // Delete user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}