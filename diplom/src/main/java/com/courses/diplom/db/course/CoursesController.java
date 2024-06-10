package com.courses.diplom.db.course;

import com.courses.diplom.db.account.token.TokenService;
import com.courses.diplom.db.account.user.User;
import com.courses.diplom.db.account.user.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CoursesController {
    private final CourseService courseService;
    private final UserService userService;


    @GetMapping("/my-courses")
    public ResponseEntity<List<CourseDto>> shareUserCourses(HttpServletRequest request) {
        User user = userService.getUserByRequest(request);
        return ResponseEntity.ok(courseService.getUserCourse(user.getId()));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CourseDto>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @PostMapping("/registered")
    public ResponseEntity<List<CourseDto>> registeredToCourse(HttpServletRequest request) {
        User user = userService.getUserByRequest(request);
        Course course = courseService.getCourseByRequest(request);

        courseService.registeredToCourse(user, course);
        return ResponseEntity.ok(courseService.getUserCourse(user.getId()));
    }
}
