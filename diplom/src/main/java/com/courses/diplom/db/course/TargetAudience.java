package com.courses.diplom.db.course;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "target_audience")
@Builder
public class TargetAudience {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, length = 300)
    private String description;

    @ManyToMany(mappedBy = "audiences")
    private List<Course> courses = new LinkedList<>();
}
