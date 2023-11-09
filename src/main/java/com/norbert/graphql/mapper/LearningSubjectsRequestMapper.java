package com.norbert.graphql.mapper;

import com.norbert.graphql.entity.Student;
import com.norbert.graphql.entity.Subject;
import com.norbert.graphql.request.LearningSubjectRequest;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
@AllArgsConstructor
public class LearningSubjectsRequestMapper implements Function<List<LearningSubjectRequest>,List<Subject>> {
    private Student student;
    @Override
    public List<Subject> apply(List<LearningSubjectRequest> learningSubjectRequests) {
        return learningSubjectRequests.stream()
                .map(learningSubjectRequest -> Subject.builder()
                        .id(learningSubjectRequest.getId())
                        .subjectName(learningSubjectRequest.getSubjectName())
                        .marksObtained(learningSubjectRequest.getMarksObtained())
                        .student(student)
                        .build()
                ).collect(Collectors.toList());
    }
}
