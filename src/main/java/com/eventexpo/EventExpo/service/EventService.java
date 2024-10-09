package com.eventexpo.EventExpo.service;

import com.eventexpo.EventExpo.model.Event;
import com.eventexpo.EventExpo.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, Event eventDetails) {
        return eventRepository.findById(id).map(event -> {
            event.setTitle(eventDetails.getTitle());
            event.setDescription(eventDetails.getDescription());
            event.setLocation(eventDetails.getLocation());
            event.setImageUrl(eventDetails.getImageUrl());
            event.setStartDateTime(eventDetails.getStartDateTime());
            event.setEndDateTime(eventDetails.getEndDateTime());
            event.setPrice(eventDetails.getPrice());
            event.setFree(eventDetails.isFree());
            event.setCategory(eventDetails.getCategory());
            event.setOrganizer(eventDetails.getOrganizer());
            return eventRepository.save(event);
        }).orElseThrow(() -> new RuntimeException("Event not found with id " + id));
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
