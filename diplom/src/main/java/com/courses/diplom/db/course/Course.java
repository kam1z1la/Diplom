package com.courses.diplom.db.course;

import com.courses.diplom.db.course.event.Event;
import com.courses.diplom.db.module.module.Module;
import com.courses.diplom.db.account.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
//@NamedEntityGraphs({
//        @NamedEntityGraph(
//                name = "course-category-graph",
//                attributeNodes = {
//                        @NamedAttributeNode("category")
//                }
//        )
//})
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "course_cover", nullable = false, length = 500)
    private String courseCover;

    @Column(name = "is_paid")
    private boolean isPaid;

    private BigDecimal price;

    @ManyToMany(mappedBy = "courses")
    private Set<User> users = new HashSet<>();

    @OneToMany(mappedBy = "course")
    @JsonBackReference
    private Set<Module> modules = new HashSet<>();

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "course_experts",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "experts_id")
    )
    private Set<Expert> experts = new HashSet<>();

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "course_target_audience",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "target_audience_id")
    )
    private Set<TargetAudience> audiences = new HashSet<>();

    @OneToMany(mappedBy = "course")
    @JsonBackReference
    private Set<Event> events = new HashSet<>();
}
