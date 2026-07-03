package com.example.college_event.service;

import com.example.college_event.model.Event;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    private final List<Event> events = new ArrayList<>();

    public EventService() {
        Event event = new Event(
                "30-Jun-2026",
                "Event Name",
                "Event Description",
                "High",
                "Mr.X",
                1000
        );
        event.setId(1);
        events.add(event);
    }

    // Get All Events
    public List<Event> getAllEvents() {
        return events;
    }

    // Get Event By ID
    public Event getEventById(Integer id) {
        for (Event event : events) {
            if (event.getId().equals(id)) {
                return event;
            }
        }
        return null;
    }

    // Add New Event
    public void addEvent(Event event) {
        event.setId(events.size() + 1);
        events.add(event);
    }

    // Update Event
    public void updateEvent(Integer id, Event updatedEvent) {
        for (Event event : events) {
            if (event.getId().equals(id)) {
                event.setEventName(updatedEvent.getEventName());
                event.setDescription(updatedEvent.getDescription());
                event.setFootFall(updatedEvent.getFootFall());
                event.setGuest(updatedEvent.getGuest());
                event.setDate(updatedEvent.getDate());
                event.setFees(updatedEvent.getFees());
                return;
            }
        }
    }

    // Delete Event
    public void deleteEvent(Integer id) {
        events.removeIf(event -> event.getId().equals(id));
    }
}