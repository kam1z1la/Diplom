package com.courses.diplom.db.module.topic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TopicDto {
    private Long id;
    private String name;
    private String text;
}
