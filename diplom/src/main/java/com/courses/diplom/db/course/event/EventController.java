package com.courses.diplom.db.course.event;

import com.courses.diplom.db.account.user.User;
import com.courses.diplom.db.account.user.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;
    private final UserService userService;

    @GetMapping("/events")
    public ResponseEntity<List<Event>> shareUserCourses(HttpServletRequest request) {
        User user = userService.getUserByRequest(request);
        return ResponseEntity.ok(eventService.getCourseEventForUser(user.getId()));
    }

}
