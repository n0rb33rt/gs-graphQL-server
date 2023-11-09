package com.norbert.graphql.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Check;

@Entity(name = "Subject")
@Table(name = "subject")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    @Id
    @SequenceGenerator(
            allocationSize = 1,
            sequenceName = "subject_id_seq",
            name = "subject_id_seq"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "subject_id_seq"
    )
    @Column(
            name = "id",
            updatable = false,
            columnDefinition = "BIGINT"
    )
    @EqualsAndHashCode.Include
    private Long id;

    @Column(
            name = "subject_name",
            length = 50,
            columnDefinition = "VARCHAR(50)",
            nullable = false
    )
    private String subjectName;

    @Column(
            name = "marks_obtained",
            columnDefinition = "DOUBLE PRECISION",
            nullable = false
    )
    private Double marksObtained;

    @ManyToOne(
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST}
    )
    @JoinColumn(
            name = "student_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "student_id_fk")
    )
    private Student student;

}
