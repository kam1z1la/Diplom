package com.courses.diplom.db.module.module;

import com.courses.diplom.db.module.test.TestDto;
import com.courses.diplom.db.module.test.TestService;
import com.courses.diplom.db.module.topic.TopicDto;
import com.courses.diplom.db.module.topic.TopicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class ModelService {
    private final ModuleRepository moduleRepository;

    public Set<Module> getModuleData(Long id) {
        return moduleRepository.getMaterialsById(id);
    }
}


