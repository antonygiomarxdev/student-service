package com.services.ms.student.student_service.application.ports.input;

import com.services.ms.student.student_service.domain.model.Student;

import java.util.List;

public interface StudentServicePort {

    Student findById(Long id);

    Student save(Student student);

    Student update(Long id, Student student);


    void delete(Long id);


    List<Student> findAll();


}

