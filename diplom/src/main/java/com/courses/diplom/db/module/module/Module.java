package com.courses.diplom.db.module.module;

import com.courses.diplom.db.course.Course;
import com.courses.diplom.db.module.test.Test;
import com.courses.diplom.db.module.topic.Topic;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "module")
@NamedEntityGraph(
        name = "module-graph",
        attributeNodes = {
                @NamedAttributeNode("tests"),
                @NamedAttributeNode("topics")
        }
)
@Builder
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 200)
    private String name;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonManagedReference
    @JsonIgnore
    private Course course;

    @OneToMany(mappedBy = "module", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Topic> topics = new HashSet<>();

    @OneToMany(mappedBy = "module", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Test> tests = new HashSet<>();
}
