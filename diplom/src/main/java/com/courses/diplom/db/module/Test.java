package com.courses.diplom.db.module;

import com.courses.diplom.db.course.Course;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "test")
@Builder
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 200)
    private String name;

    private double scoring;

    private int rating;

    @OneToMany(mappedBy = "test")
    private List<Question> orders = new LinkedList<>();

    @OneToMany(mappedBy = "test")
    private List<Module> modules = new LinkedList<>();
}
