package com.yourcompany.eventmgmt.service;

import com.yourcompany.eventmgmt.dto.EventRequest;
import com.yourcompany.eventmgmt.entity.Event;
import com.yourcompany.eventmgmt.entity.User;
import com.yourcompany.eventmgmt.repository.EventRepository;
import com.yourcompany.eventmgmt.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public EventService(EventRepository eventRepository, UserRepository userRepository){
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    public Event create(EventRequest req){
        User u = userRepository.findById(req.getUserId()).orElseThrow(() -> new IllegalArgumentException("User not found"));
        Event e = new Event();
        e.setUser(u);
        e.setType(req.getType());
        e.setPrimaryName(req.getPrimaryName());
        e.setSecondaryName(req.getSecondaryName());
        e.setBudget(req.getBudget());
        e.setTotalPerson(req.getTotalPerson());
        // parse date yyyy-MM-dd
        e.setEventDate(LocalDate.parse(req.getEventDate()));
        e.setLocation(req.getLocation());
        return eventRepository.save(e);
    }
    
    

    public List<Event> listAll(){ return eventRepository.findAll(); }
    public List<Event> listByType(String type){ return eventRepository.findByType(type); }
    public List<Event> listByUser(Long userId){ return eventRepository.findByUserId(userId); }
}
