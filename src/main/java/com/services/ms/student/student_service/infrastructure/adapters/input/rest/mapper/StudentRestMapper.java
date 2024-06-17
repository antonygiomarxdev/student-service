package com.services.ms.student.student_service.infrastructure.adapters.input.rest.mapper;

import com.services.ms.student.student_service.domain.model.Student;
import com.services.ms.student.student_service.infrastructure.adapters.input.rest.model.request.StudentCreateRequest;
import com.services.ms.student.student_service.infrastructure.adapters.input.rest.model.response.StudentResponse;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface StudentRestMapper {


    Student toStudent(StudentCreateRequest studentCreateRequest);


    StudentCreateRequest toStudentCreateRequest(Student student);

    StudentResponse toStudentResponse(Student student);


    List<StudentResponse> toStudentResponses(List<Student> students);

    List<Student> toStudents(List<StudentCreateRequest> studentCreateRequests);
}
