package com.example.college_event.controller;

import com.example.college_event.model.Event;
import com.example.college_event.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@CrossOrigin("*")
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    // ==========================
    // GET ALL EVENTS
    // ==========================
    @GetMapping
    public List<Event> getEvents() {

        return service.getAllEvents();

    }

    // ==========================
    // GET EVENT BY ID
    // ==========================
    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Integer id) {

        return service.getEventById(id);

    }

    // ==========================
    // ADD NEW EVENT
    // ==========================
    @PostMapping
    public String addEvent(@RequestBody Event event) {

        service.addEvent(event);

        return "Event Added Successfully";

    }

    // ==========================
    // UPDATE EVENT
    // ==========================
    @PutMapping("/{id}")
    public String updateEvent(@PathVariable Integer id,
                             @RequestBody Event event) {

        service.updateEvent(id, event);

        return "Event Updated Successfully";

    }

    // ==========================
    // DELETE EVENT
    // ==========================
    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable Integer id) {

        service.deleteEvent(id);

        return "Event Deleted Successfully";

    }

}