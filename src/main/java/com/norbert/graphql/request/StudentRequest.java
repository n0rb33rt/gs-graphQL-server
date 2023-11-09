package com.norbert.graphql.request;

import lombok.*;

import java.util.List;


@Getter
@Setter
public class StudentRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private AddressRequest address;
    private List<LearningSubjectRequest> learningSubjects;
}
