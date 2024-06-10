package com.courses.diplom.db.course;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    //    @EntityGraph(attributePaths = {"users"}, type = EntityGraph.EntityGraphType.LOAD)

    @Query(value = """
            select new com.courses.diplom.db.course.CourseDto(
            c.id,
            c.name,
            c.description,
            ct.name,
            c.courseCover,
            c.isPaid)
            from Course c right join  c.category ct on c.category.id = ct.id
            left join c.users u where u.id = :id""")
    List<CourseDto> userCourses(Long id);

    //    @EntityGraph(value = "course-category-graph", type = EntityGraph.EntityGraphType.LOAD)
    @Query(value = """
            select new com.courses.diplom.db.course.CourseDto(
            c.id,
            c.name,
            c.description,
            ct.name,
            c.courseCover,
            c.isPaid)
            from Course c join c.category ct on c.category.id = ct.id""")
    List<CourseDto> findAllCourse();

    @Query(value = "select count(*) > 0 from user_course where user_id = :userId and course_id = :courseId",
            nativeQuery = true)
    boolean userHasCurrentCourses(Long userId, Long courseId);

    @Modifying
    @Transactional
    @Query(value = "insert into user_course(user_id, course_id) values (:userId,:courseId)", nativeQuery = true)
    void registerUserToCourse(Long userId, Long courseId);
}
