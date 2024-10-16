package com.eventexpo.EventExpo.service;
//
import com.eventexpo.EventExpo.model.User;
import com.eventexpo.EventExpo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
}