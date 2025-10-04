package com.courses.diplom.db.module.result;

import com.courses.diplom.db.account.user.User;
import com.courses.diplom.db.module.test.Test;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "result")
@NamedEntityGraph(
        name = "result-graph",
        attributeNodes = {
                @NamedAttributeNode("test"),
                @NamedAttributeNode("user")
        }
)
@Builder
@ToString
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int total;

    private int correct;

    private int wrong;

    @Column(name = "correct_percentage")
    private int correctPercentage;

    @Column(name = "wrong_percentage")
    private int wrongPercentage;

    @ManyToOne
    @JoinColumn(name = "test_id", referencedColumnName = "id")
    @JsonBackReference
    private Test test;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;
}
