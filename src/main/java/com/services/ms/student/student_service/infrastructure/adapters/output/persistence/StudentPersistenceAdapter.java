package com.services.ms.student.student_service.infrastructure.adapters.output.persistence;

import com.services.ms.student.student_service.application.ports.output.StudentPersistencePort;
import com.services.ms.student.student_service.domain.model.Student;
import com.services.ms.student.student_service.infrastructure.adapters.output.persistence.mapper.StudentPersistenceMapper;
import com.services.ms.student.student_service.infrastructure.adapters.output.persistence.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class StudentPersistenceAdapter implements StudentPersistencePort {

    private final StudentRepository studentRepository;
    private final StudentPersistenceMapper studentPersistenceMapper;

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id).map(studentPersistenceMapper::toStudent);
    }

    @Override
    public Student save(Student student) {
        return studentPersistenceMapper.toStudent(studentRepository.save(studentPersistenceMapper.toStudentEntity(student)));
    }

    @Override
    public Student update(Student student) {
        return studentPersistenceMapper.toStudent(studentRepository.save(studentPersistenceMapper.toStudentEntity(student)));
    }

    @Override
    public void delete(Long id) {

        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentPersistenceMapper.toStudents(studentRepository.findAll());
    }

    @Override
    public Optional<Student> deleteById(Long id) {
        return studentRepository.findById(id).map(student -> {
            studentRepository.deleteById(id);
            return studentPersistenceMapper.toStudent(student);
        });
    }
}
