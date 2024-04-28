package com.shepherdmoney.interviewproject.controller;

import com.shepherdmoney.interviewproject.model.User;
import com.shepherdmoney.interviewproject.repository.UserRepository;
import com.shepherdmoney.interviewproject.vo.request.CreateUserPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;  // Wire in the UserRepository

    @PutMapping("/user")
    public ResponseEntity<Integer> createUser(@RequestBody CreateUserPayload payload) {
        User newUser = new User();  // Assuming User is your entity class
        newUser.setName(payload.getName());  // Set properties based on payload
        newUser.setEmail(payload.getEmail());
        newUser = userRepository.save(newUser);  // Save the new user
        return ResponseEntity.ok(newUser.getId());  // Return the user ID
    }

    @DeleteMapping("/user")
    public ResponseEntity<String> deleteUser(@RequestParam int userId) {
        return userRepository.findById(userId)
            .map(user -> {
                userRepository.delete(user);
                return ResponseEntity.ok("User deleted successfully");
            })
            .orElseGet(() -> ResponseEntity.badRequest().body("User not found"));
    }
}
