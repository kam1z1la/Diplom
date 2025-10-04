package com.courses.diplom.db.module.topic;

import com.courses.diplom.db.module.module.Module;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "topics")
@Builder
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false, length = 200)
    private String links;

    @ManyToOne
    @JoinColumn(name = "module_id")
    @JsonBackReference
    private Module module;
}
