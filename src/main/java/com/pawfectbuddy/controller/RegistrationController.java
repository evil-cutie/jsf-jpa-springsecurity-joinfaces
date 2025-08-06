package com.pawfectbuddy.controller;

import com.pawfectbuddy.controller.dto.RegistrationRequest;
import com.pawfectbuddy.service.UserServiceInterface;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Receives POST requests from LocalServiceCaller and saves new user in a database via UserService
 * @author Xenia Levit
 */

@RestController
@RequestMapping("/api/users")
public class RegistrationController {

    @Autowired
    private UserServiceInterface userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest registrationRequest) {
        try {
            userService.registerUser(registrationRequest);
            return new ResponseEntity<>("User is created successfully", HttpStatus.OK);
        } catch (EntityExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

