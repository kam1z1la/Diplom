package com.courses.diplom.db.module.test;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository repository;

    public Test getTest(long id) {
        return repository.findById(id).orElseThrow();
    }

//    public Set<TestDto> getTests(Long id) {
//        return repository.getTestsByModuleId(id);
//    }
}
