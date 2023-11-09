package com.norbert.graphql.controller;

import com.norbert.graphql.request.StudentRequest;
import com.norbert.graphql.response.StudentResponse;
import com.norbert.graphql.service.StudentService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StudentMutation implements GraphQLMutationResolver {
    private final StudentService studentService;

    public StudentResponse newStudent(StudentRequest studentRequest){
        return studentService.save(studentRequest);
    }
    public StudentResponse deleteStudentById(Long id){
        return studentService.deleteStudentById(id);
    }
    public StudentResponse updateStudent(StudentRequest studentRequest){
        return studentService.updateStudent(studentRequest);
    }
}
