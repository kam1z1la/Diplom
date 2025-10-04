package com.courses.diplom.db.module.test;

import com.courses.diplom.db.module.Question;
import com.courses.diplom.db.module.result.Result;
import com.courses.diplom.db.module.module.Module;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedList;
import java.util.List;

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

    @Column(name = "test_complete")
    @JsonIgnore
    private boolean testComplete;

    @OneToMany(mappedBy = "test", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Question> questions = new LinkedList<>();

    @ManyToOne
    @JoinColumn(name = "module_id")
    @JsonBackReference
    private Module module;

    @OneToMany(mappedBy = "test", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Result> result;
}
