package com.courses.diplom.db.module.award;

import com.courses.diplom.db.account.user.User;
import com.courses.diplom.db.account.user.UserService;
import com.courses.diplom.db.course.CourseService;
import com.courses.diplom.db.module.result.ResultService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AwardService {
    private final ResultService resultService;
    private final CourseService courseService;

    public Award createAward(User user) {
        int courses = courseService.countingPurchasedCourses(user.getId());
        int questions = resultService.countTotalQuestion(user.getId());

        return Award.builder()
                .countCourse(courses)
                .countQuestion(questions)
                .build();
    }
}
