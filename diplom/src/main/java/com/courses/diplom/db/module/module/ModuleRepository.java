package com.courses.diplom.db.module.module;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {

    @EntityGraph(value = "module-graph", type = EntityGraph.EntityGraphType.LOAD)
    @Query(value = "select m from Module m where m.course.id = :id")
    Set<Module> getMaterialsById(Long id);
}
