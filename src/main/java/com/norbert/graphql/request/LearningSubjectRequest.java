package com.norbert.graphql.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LearningSubjectRequest {
    private Long id;
    private String subjectName;
    private Double marksObtained;
}
