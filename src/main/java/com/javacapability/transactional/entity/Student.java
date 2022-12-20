package com.javacapability.transactional.entity;

import javax.persistence.*;

import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "stream")
    private String stream;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private List<Subjects> subjects;

}

