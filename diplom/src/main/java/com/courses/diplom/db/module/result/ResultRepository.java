package com.courses.diplom.db.module.result;

import com.courses.diplom.db.account.user.User;
import com.courses.diplom.db.module.test.Test;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

    //    @Query("select count(r) > 0 from Result r where r.user.id = :userId and r.test.id = :testId")
//    boolean isResultExists(Long userId, Long testId);
    @EntityGraph(value = "result-graph", type = EntityGraph.EntityGraphType.LOAD)
    @Query("select r from Result r where r.user.id = :userId and r.test.id = :testId")
    Optional<Result> getResult(Long userId, Long testId);

    @Modifying
    @Transactional
    @Query(value = """
               update result set
               total = :#{#result.total},
               correct = :#{#result.correct},
               wrong = :#{#result.wrong},
               correct_percentage = :#{#result.correctPercentage},
               wrong_percentage = :#{#result.wrongPercentage},
               user_id =  :#{#user.id},
               test_id =  :#{#test.id}
               where id = :#{#result.id}""",
            nativeQuery = true)
    void updateResult(User user, Test test, Result result);

    @Query(value = """
               select sum(r.total) from Result r
               join r.user u
               where u.id = :userId""")
    Optional<Integer>  countTotalQuestion(Long userId);
}
