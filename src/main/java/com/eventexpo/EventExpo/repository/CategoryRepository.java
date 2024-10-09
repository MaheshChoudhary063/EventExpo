package com.eventexpo.EventExpo.repository;

import com.eventexpo.EventExpo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
