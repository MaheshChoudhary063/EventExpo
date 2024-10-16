
package com.eventexpo.EventExpo.service;

import com.eventexpo.EventExpo.model.User;
import com.eventexpo.EventExpo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        return savedUser;
    }
//
//    public Optional<User> getUserByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }

    public String generateToken(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
        return jwtService.generateToken(email, user.getRoles());
    }
}
