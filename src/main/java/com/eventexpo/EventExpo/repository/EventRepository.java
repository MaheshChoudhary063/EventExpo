package com.eventexpo.EventExpo.repository;

import com.eventexpo.EventExpo.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
