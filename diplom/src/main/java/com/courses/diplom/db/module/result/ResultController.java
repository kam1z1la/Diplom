package com.courses.diplom.db.module.result;

import com.courses.diplom.db.account.user.User;
import com.courses.diplom.db.account.user.UserService;
import com.courses.diplom.db.module.test.Test;
import com.courses.diplom.db.module.test.TestService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ResultController {
    private final UserService userService;
    private final ResultService resultService;
    private final TestService testService;

    @GetMapping("/get-result")
    public ResponseEntity<Result> getResult(HttpServletRequest request,
                                            @Param("testId") long testId) {
        User user = userService.getUserByRequest(request);
        Result result = resultService.getResult(user.getId(), testId);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/save-result")
    public ResponseEntity<String> saveResult(HttpServletRequest request,
                                             @Param("testId") long testId,
                                             @RequestBody ResultDto dto) {
        User user = userService.getUserByRequest(request);
        Test test = testService.getTest(testId);

        resultService.saveResult(user, test, dto);
        return ResponseEntity.ok("!");
    }
}
