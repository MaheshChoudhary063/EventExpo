package com.eventexpo.EventExpo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Changed from int to Long for consistency

    private String clerkId;
    private String username;
    private String name;
    private String email;
    private String password;
    private String roles;
    private String photo;
}
