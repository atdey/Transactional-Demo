package com.javacapability.transactional.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "subjects")
public class Subjects {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    @JsonIgnore
    private Student student;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;
}
