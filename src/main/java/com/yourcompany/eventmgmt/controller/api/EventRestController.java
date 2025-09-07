package com.yourcompany.eventmgmt.controller.api;

import com.yourcompany.eventmgmt.dto.EventRequest;
import com.yourcompany.eventmgmt.entity.Event;
import com.yourcompany.eventmgmt.service.EventService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventRestController {
    private final EventService eventService;
    public EventRestController(EventService eventService){ this.eventService = eventService; }

    
    
    @PostMapping
    public Event create(@Valid @RequestBody EventRequest req){
        return eventService.create(req);
    }

    
    
    @GetMapping
    public List<Event> all(){ return eventService.listAll(); }

    
    
    @GetMapping("/type/{type}")
    public List<Event> byType(@PathVariable String type){ return eventService.listByType(type); }

    
    
    @GetMapping("/user/{userId}")
    public List<Event> byUser(@PathVariable Long userId){ return eventService.listByUser(userId); }
}
