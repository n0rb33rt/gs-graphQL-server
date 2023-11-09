package com.norbert.graphql.controller;

import com.norbert.graphql.response.StudentResponse;
import com.norbert.graphql.service.StudentService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Component;


import java.util.List;

@Component
@AllArgsConstructor
public class StudentQuery implements GraphQLQueryResolver {
    private final StudentService studentService;

    public List<StudentResponse> getStudents(){
        return studentService.getStudents();
    }

    public StudentResponse getStudentById(Long id){
        return studentService.getStudentById(id);
    }
}
