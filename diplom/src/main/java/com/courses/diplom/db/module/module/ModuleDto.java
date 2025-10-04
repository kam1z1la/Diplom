package com.courses.diplom.db.module.module;

import com.courses.diplom.db.module.test.TestDto;
import com.courses.diplom.db.module.topic.TopicDto;
import com.courses.diplom.db.module.topic.Topic;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ModuleDto {
    private Long id;
    private String name;
    private Long courseId;
    private Set<TestDto> tests;
    private Set<Topic> topics;


    public ModuleDto(Long id, String name, Long courseId, Set<Topic> topics) {
        this.id = id;
        this.name = name;
        this.courseId = courseId;
        this.topics=topics;
    }
}
