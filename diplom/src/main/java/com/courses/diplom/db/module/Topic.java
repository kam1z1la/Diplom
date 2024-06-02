package com.courses.diplom.db.module;

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
    private Module module;
}
