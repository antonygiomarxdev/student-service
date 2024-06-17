package com.services.ms.student.student_service.application.services;

import com.services.ms.student.student_service.application.ports.input.StudentServicePort;
import com.services.ms.student.student_service.application.ports.output.StudentPersistencePort;
import com.services.ms.student.student_service.domain.exception.StudentNotFoundException;
import com.services.ms.student.student_service.domain.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements StudentServicePort {

    private final StudentPersistencePort studentPersistencePort;

    @Override
    public Student findById(Long id) {
        return studentPersistencePort.findById(id).orElseThrow(
                StudentNotFoundException::new);
    }

    @Override
    public Student save(Student student) {
        return studentPersistencePort.save(student);
    }

    @Override
    public Student update(Long id, Student student) {
        return studentPersistencePort.findById(student.getId()).map(s -> {
            s.setFirstName(student.getFirstName());
            s.setLastName(student.getLastName());
            s.setAge(student.getAge());
            s.setAddress(student.getAddress());
            return studentPersistencePort.update(s);
        }).orElseThrow(
                StudentNotFoundException::new);
    }

    @Override
    public void delete(Long id) {

        if (studentPersistencePort.findById(id).isEmpty()) {
            throw new StudentNotFoundException();
        }

        studentPersistencePort.delete(id);
    }

    @Override
    public List<Student> findAll() {
        return studentPersistencePort.findAll();
    }
}
