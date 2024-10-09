package com.eventexpo.EventExpo.repository;

import com.eventexpo.EventExpo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}