package com.yourcompany.eventmgmt.util;

import com.yourcompany.eventmgmt.entity.User;
import com.yourcompany.eventmgmt.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthUtil {
    private final UserRepository userRepository;
    public AuthUtil(UserRepository userRepository){ this.userRepository = userRepository; }

    // helper to fetch user by id (since frontend sends userId)
    public Optional<User> getUserById(Long id){ return userRepository.findById(id); }
}
