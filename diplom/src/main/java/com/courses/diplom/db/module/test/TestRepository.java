package com.courses.diplom.db.module.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
//    @Query("""
//select new com.courses.diplom.db.module.test.TestDto(
//    t.id,
//    t.name,
//    t.questions
//)
//from Test t
//join t.questions q
//where t.module.id = :id
//""")
//    Set<TestDto> getTestsByModuleId(Long id);

    @Query("""
select distinct t from Test t
left join fetch t.questions
where t.module.id = :id
""")
    List<Test> getTestsByModuleId(Long id);
}
