package com.courses.diplom.db.course;

import com.courses.diplom.db.account.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "experts")
@Builder
public class Expert {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @Column(nullable = false, length = 300)
    private String description;

    @ManyToMany(mappedBy = "experts")
    private List<Course> courses = new LinkedList<>();
}
