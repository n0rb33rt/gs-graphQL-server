package com.norbert.graphql.response;

import com.norbert.graphql.entity.Student;
import lombok.*;

import java.util.List;


@Getter
@Setter
public class StudentResponse {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private AddressResponse address;

    private List<SubjectResponse> learningSubjects;

    private Student student; // for internal using

    public StudentResponse(Student student){
        this.student = student;
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
    }
}
