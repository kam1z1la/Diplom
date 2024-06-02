package com.courses.diplom.db.course;

import com.courses.diplom.db.module.Module;
import com.courses.diplom.db.account.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.text.DecimalFormat;
import java.util.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
@NamedEntityGraph(
        name = "course-entity-graph",
        attributeNodes = {
                @NamedAttributeNode("category"),
                @NamedAttributeNode("users"),
                @NamedAttributeNode("experts"),
                @NamedAttributeNode("modules"),
                @NamedAttributeNode("audiences")
        }
)
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "course_cover", nullable = false, length = 500)
    private String courseCover;

    @Column(name = "is_paid")
    private boolean isPaid;

    private DecimalFormat price;

    @ManyToMany(mappedBy = "courses")
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    private List<Module> modules = new LinkedList<>();

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "course_experts",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "experts_id")
    )
    private List<Expert> experts = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "course_target_audience",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "target_audience_id")
    )
    private Set<TargetAudience> audiences = new HashSet<>();
}
