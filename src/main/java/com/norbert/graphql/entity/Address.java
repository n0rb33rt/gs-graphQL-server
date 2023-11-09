package com.norbert.graphql.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Address")
@Table(name = "address")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @SequenceGenerator(
            allocationSize = 1,
            sequenceName = "address_id_seq",
            name = "address_id_seq"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_id_seq"
    )
    @Column(
            name = "id",
            updatable = false
    )
    @EqualsAndHashCode.Include
    private Long id;

    @Column(
            name = "street",
            columnDefinition = "VARCHAR(50)",
            nullable = false
    )
    private String street;

    @Column(
            name = "city",
            columnDefinition = "VARCHAR(50)",
            nullable = false
    )
    private String city;

    @OneToOne(
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST},
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "student_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "student_id_fk")
    )
    private Student student;
}
