package com.courses.diplom.db.module.module;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ModuleController {
private final ModelService modelService;

    @GetMapping("/material/{id}")
    public ResponseEntity<Set<Module>> getMaterialCourse(@PathVariable("id") Long id) {
        return ResponseEntity.ok(modelService.getModuleData(id));
    }
}
