package com.courses.diplom.db.course;

import com.courses.diplom.db.account.token.TokenService;
import com.courses.diplom.db.account.user.User;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TokenService tokenService;

    public List<CourseDto> getUserCourse(Long id) {
        return courseRepository.userCourses(id);
    }

    public List<CourseDto> getAllCourses() {
        return courseRepository.findAllCourse();
    }

    public Course getCourseByRequest(HttpServletRequest request) {
        Long id = tokenService.getCourseIdFromHttpRequest(request);
        return courseRepository.findById(id).orElseThrow();
    }

    public void registeredToCourse(User user, Course course) {
        if (!courseRepository.userHasCurrentCourses(user.getId(), course.getId())) {
            courseRepository.registerUserToCourse(user.getId(), course.getId());
        }
    }

    public int countingPurchasedCourses(Long userId) {
        return courseRepository.countUserCourses(userId).orElse(0);
    }
}
