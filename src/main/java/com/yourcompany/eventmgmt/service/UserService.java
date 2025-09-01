package com.yourcompany.eventmgmt.service;

import com.yourcompany.eventmgmt.dto.SignupRequest;
import com.yourcompany.eventmgmt.dto.LoginRequest;
import com.yourcompany.eventmgmt.entity.User;
import com.yourcompany.eventmgmt.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(SignupRequest req){
        if(userRepository.existsByEmail(req.getEmail())){
            throw new IllegalArgumentException("Email already registered");
        }
        if(!req.getPassword().equals(req.getConfirmPassword())){
            throw new IllegalArgumentException("Passwords do not match");
        }
        User u = new User();
        u.setUsername(req.getUsername());
        u.setUserage(req.getUserage());
        u.setEmail(req.getEmail());
        u.setPasswordHash(passwordEncoder.encode(req.getPassword()));
        return userRepository.save(u);
    }

    public User validateLogin(LoginRequest req){
        Optional<User> opt = userRepository.findByEmail(req.getEmail());
        if(opt.isEmpty()) throw new IllegalArgumentException("Invalid credentials");
        User u = opt.get();
        if(!passwordEncoder.matches(req.getPassword(), u.getPasswordHash())){
            throw new IllegalArgumentException("Invalid credentials");
        }
        return u;
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }
}
