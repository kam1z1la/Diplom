package com.courses.diplom.db.course.event;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    public List<Event> getCourseEventForUser(Long userId) {
        return eventRepository.findAllEventsByUserId(userId);
    }
}
