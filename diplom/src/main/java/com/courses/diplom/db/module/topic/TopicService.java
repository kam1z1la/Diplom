package com.courses.diplom.db.module.topic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class TopicService {
    private final TopicRepository topicRepository;

    public Set<Topic> getTopics(Long id) {
        return topicRepository.getTopicsByModuleId(id);
    }
}
