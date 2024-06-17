package com.services.ms.student.student_service.application.ports.output;

import com.services.ms.student.student_service.domain.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentPersistencePort {

    Optional<Student> findById(Long id);

    Student save(Student student);

    Student update(Student student);

    void delete(Long id);

    List<Student> findAll();

    Optional<Student> deleteById(Long id);

}
