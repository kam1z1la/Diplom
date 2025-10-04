package com.courses.diplom.db.module.test;

import com.courses.diplom.db.module.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class TestDto {
    private Long id;
    private String name;
    private String questions;

    public TestDto(Long id, String name, List<Question> questions) {
        this.id = id;
        this.name = name;
        this.questions = questions.toString();
    }
}
