package com.courses.diplom.db.module.test;

import com.courses.diplom.db.module.module.ModuleDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TestController {
    private final TestRepository testRepository;

    @GetMapping("/all-test")
    public ResponseEntity<List<Test>> getMaterialCourse() {
        return ResponseEntity.ok(testRepository.getTestsByModuleId(2L));
    }
}
