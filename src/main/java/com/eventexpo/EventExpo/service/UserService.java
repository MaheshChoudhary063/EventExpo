package com.eventexpo.EventExpo.service;

import com.eventexpo.EventExpo.model.UserInfo;
import com.eventexpo.EventExpo.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepository.save(userInfo);
        return "User added to system";
    }

    // Get a user by ID
    public UserInfo getUserById(Long userId) {
        return userInfoRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
    }

    // Get all users
    public List<UserInfo> getAllUsers() {
        return userInfoRepository.findAll();
    }

    // Update an existing user, ensuring password is encoded
    public UserInfo updateUser(Long id, UserInfo userDetails) {
        UserInfo existingUser = userInfoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));

        existingUser.setEmail(userDetails.getEmail());
        existingUser.setUsername(userDetails.getUsername());
        existingUser.setName(userDetails.getName());

        // Ensure the password is re-encoded if it's different
        if (!passwordEncoder.matches(userDetails.getPassword(), existingUser.getPassword())) {
            existingUser.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        }

        existingUser.setRoles(userDetails.getRoles());
        existingUser.setPhoto(userDetails.getPhoto());

        return userInfoRepository.save(existingUser);
    }

    // Delete a user by ID
    public void deleteUser(Long id) {
        userInfoRepository.deleteById(id);
    }
}