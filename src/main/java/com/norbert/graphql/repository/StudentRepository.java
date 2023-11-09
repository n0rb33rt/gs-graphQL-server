package com.norbert.graphql.repository;

import com.norbert.graphql.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
