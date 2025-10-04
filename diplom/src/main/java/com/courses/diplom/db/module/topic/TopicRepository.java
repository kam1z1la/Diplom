package com.courses.diplom.db.module.topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
//    @Query("""
//            select new com.courses.diplom.db.module.topic.TopicDto(
//            t.id,
//            t.name,
//            t.text)
//            from Topic t where t.module.id = :id""")
    @Query("""
            select t from Topic t where t.module.id = :id""")
    Set<Topic> getTopicsByModuleId(Long id);
}
