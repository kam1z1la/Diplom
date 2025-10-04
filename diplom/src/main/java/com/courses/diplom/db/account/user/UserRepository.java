package com.courses.diplom.db.account.user;

import com.courses.diplom.db.account.user.dto.UserDto;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = {"roles"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("select u from User u where u.mail = :mail")
    Optional<User> findByMail(String mail);

    @Query("select count(u) > 0 from User u where u.mail = :email")
    boolean existsByEmail(String email);

    @Modifying
    @Transactional
    @Query("update User u set u.password = :newPassword where u.id = :id")
    void updatePassword(String newPassword, Long id);

    @Modifying
    @Transactional
    @Query(value = """
            update "user" set
            first_name = :#{#user.firstName},
            last_name = :#{#user.lastName},
            mail = :#{#user.mail},
            phone_number = :#{#user.phoneNumber}
            where id = :#{#user.id}""",
            nativeQuery = true)
    void updateUser(UserDto user);
}
