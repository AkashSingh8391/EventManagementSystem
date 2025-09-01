package com.yourcompany.eventmgmt.repository;

import com.yourcompany.eventmgmt.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByType(String type);
    List<Event> findByUserId(Long userId);
}
