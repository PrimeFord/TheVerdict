package com.theverdict.theverdict.controller;


import com.theverdict.theverdict.model.User;
import com.theverdict.theverdict.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Get all users (ADMIN only)
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/debug/roles")
    public String checkRoles() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("User Authorities: " + authentication.getAuthorities());
        return "Check your console for roles!";
    }
    // Get a specific user by ID (ADMIN only)
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Full update of user (PUT) (ADMIN only)
    @PutMapping("/{id}")
    public Optional<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

    // Partial update of user (PATCH) (ADMIN only)
    @PatchMapping("/{id}")
    public Optional<User> partialUpdateUser(@PathVariable Long id, @RequestBody User partialUser) {
        return userService.partialUpdateUser(id, partialUser);
    }

    // Delete user (ADMIN only)
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted successfully.";
    }
}