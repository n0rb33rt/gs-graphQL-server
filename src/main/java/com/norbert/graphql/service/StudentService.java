package com.norbert.graphql.service;

import com.norbert.graphql.entity.Address;
import com.norbert.graphql.entity.Subject;
import com.norbert.graphql.exception.BadRequestException;
import com.norbert.graphql.mapper.StudentRequestMapper;
import com.norbert.graphql.request.*;
import com.norbert.graphql.response.StudentResponse;
import com.norbert.graphql.entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentJpaService studentJpaService;

    public List<StudentResponse> getStudents() {
        List<Student> res = studentJpaService.getStudents();
        return res.stream()
                .map(StudentResponse::new)
                .collect(Collectors.toList());
    }

    public StudentResponse getStudentById(Long id) {
        return new StudentResponse(studentJpaService.getStudentById(id));
    }

    public StudentResponse deleteStudentById(Long id){
        return new StudentResponse(studentJpaService.deleteStudentById(id));
    }
    public StudentResponse updateStudent(StudentRequest studentRequest){
        if(studentRequest.getId() == null || studentRequest.getAddress().getId() == null)
            throw new BadRequestException("Id of all fields must be provided", "id");
        Student student = studentJpaService.getStudentById(studentRequest.getId());
        StudentRequestMapper studentRequestMapper = new StudentRequestMapper(student);
        Student updatedStudent = studentRequestMapper.apply(studentRequest);
        return new StudentResponse(studentJpaService.save(updatedStudent));
    }
    public StudentResponse save(StudentRequest studentRequest) {
        Student student = createStudent(studentRequest);
        Address address = createAddress(studentRequest.getAddress());
        List<Subject> learningSubjects = createLearningSubjects(studentRequest.getLearningSubjects(),student);

        student.setLearningSubjects(learningSubjects);
        student.setAddress(address);
        address.setStudent(student);
        studentJpaService.save(student);
        return new StudentResponse(student);
    }

    private Student createStudent(StudentRequest studentRequest) {
        return Student.builder()
                .firstName(studentRequest.getFirstName())
                .lastName(studentRequest.getLastName())
                .email(studentRequest.getEmail())
                .build();
    }

    private Address createAddress(AddressRequest addressRequest) {
        return Address.builder()
                .street(addressRequest.getStreet())
                .city(addressRequest.getCity())
                .build();
    }

    private List<Subject> createLearningSubjects(List<LearningSubjectRequest> subjectRequests,Student student) {
        return subjectRequests.stream()
                .map(subjectRequest -> createSubject(subjectRequest,student))
                .collect(Collectors.toList());
    }

    private Subject createSubject(LearningSubjectRequest subjectRequest,Student student) {
        return Subject.builder()
                .subjectName(subjectRequest.getSubjectName())
                .marksObtained(subjectRequest.getMarksObtained())
                .student(student)
                .build();
    }

}
