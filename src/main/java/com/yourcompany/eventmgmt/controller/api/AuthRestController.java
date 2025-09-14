package com.yourcompany.eventmgmt.controller.api;

import com.yourcompany.eventmgmt.dto.SignupRequest;
import com.yourcompany.eventmgmt.dto.LoginRequest;
import com.yourcompany.eventmgmt.entity.User;
import com.yourcompany.eventmgmt.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {
    private final UserService userService;
    public AuthRestController(UserService userService){ this.userService = userService; }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody SignupRequest req){
        try {
            User u = userService.signup(req);
            return ResponseEntity.status(201).body(Map.of("id", u.getId(), "email", u.getEmail()));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
        }
    }
    
    

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest req){
        try {
            User u = userService.validateLogin(req);
            return ResponseEntity.ok(Map.of("userId", u.getId(), "username", u.getUsername()));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(401).body(Map.of("error", ex.getMessage()));
        }
    }
}
