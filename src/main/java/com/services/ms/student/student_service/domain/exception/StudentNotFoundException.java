package com.services.ms.student.student_service.domain.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException() {
        super("Student not found");
    }
}
