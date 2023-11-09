package com.norbert.graphql.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity(name = "Student")
@Table(name = "student")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @SequenceGenerator(
            allocationSize = 1,
            sequenceName = "student_id_seq",
            name = "student_id_seq"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_id_seq"
    )
    @Column(
            name = "id",
            updatable = false,
            columnDefinition = "BIGINT"
    )
    @EqualsAndHashCode.Include
    private Long id;

    @Column(
            name = "first_name",
            columnDefinition = "VARCHAR(40)",
            length = 40,
            nullable = false
    )
    private String firstName;

    @Column(
            name = "last_name",
            columnDefinition = "VARCHAR(40)",
            length = 40,
            nullable = false
    )
    private String lastName;

    @Column(
            name = "email",
            columnDefinition = "VARCHAR(319)",
            length = 319,
            nullable = false
    )
    private String email;

    @OneToOne(
            cascade = CascadeType.ALL,
            mappedBy = "student",
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Address address;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "student",
            fetch = FetchType.LAZY
    )
    private List<Subject> learningSubjects;


}
