package com.services.ms.student.student_service;

import com.services.ms.student.student_service.infrastructure.adapters.input.env.DotenvConfig;
import com.services.ms.student.student_service.infrastructure.adapters.output.persistence.entity.StudentEntity;
import com.services.ms.student.student_service.infrastructure.adapters.output.persistence.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class StudentServiceApplication implements CommandLineRunner {

    private final StudentRepository studentRepository;

    public static void main(String[] args) {
        DotenvConfig.SetEnv();

        SpringApplication.run(StudentServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<StudentEntity> entities = Arrays.asList(
                new StudentEntity(null, "John", "Doe", 25, "New York"),
                new StudentEntity(null, "Jane", "Doe", 22, "New York"),
                new StudentEntity(null, "Alice", "Doe", 20, "New York"),
                new StudentEntity(null, "Bob", "Doe", 30, "New York")
        );

        studentRepository.saveAll(entities);

    }
}
