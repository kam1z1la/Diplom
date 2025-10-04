package com.courses.diplom.db.course.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query(value = """
            select e from Event e join e.course.users u
            where u.id = :userId and e.date >= CURRENT_DATE""")
    List<Event> findAllEventsByUserId(Long userId);
}
