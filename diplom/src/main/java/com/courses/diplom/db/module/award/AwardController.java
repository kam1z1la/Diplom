package com.courses.diplom.db.module.award;


import com.courses.diplom.db.account.user.User;
import com.courses.diplom.db.account.user.UserService;
import com.courses.diplom.db.course.CourseService;
import com.courses.diplom.db.module.module.ModelService;
import com.courses.diplom.db.module.result.Result;
import com.courses.diplom.db.module.result.ResultService;
import com.courses.diplom.db.module.test.TestService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AwardController {
    private final AwardService awardService;
    private final UserService userService;

    @GetMapping("/user-award")
    public ResponseEntity<Award> getAwards(HttpServletRequest request) {
        User user = userService.getUserByRequest(request);
        return ResponseEntity.ok(awardService.createAward(user));
    }
}
