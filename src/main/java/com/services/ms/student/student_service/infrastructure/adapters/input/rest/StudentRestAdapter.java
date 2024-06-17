package com.services.ms.student.student_service.infrastructure.adapters.input.rest;

import com.services.ms.student.student_service.application.ports.input.StudentServicePort;
import com.services.ms.student.student_service.infrastructure.adapters.input.rest.mapper.StudentRestMapper;
import com.services.ms.student.student_service.infrastructure.adapters.input.rest.model.request.StudentCreateRequest;
import com.services.ms.student.student_service.infrastructure.adapters.input.rest.model.request.StudentUpdateRequest;
import com.services.ms.student.student_service.infrastructure.adapters.input.rest.model.response.StudentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentRestAdapter {

    private final StudentServicePort studentServicePort;

    private final StudentRestMapper studentRestMapper;

    @GetMapping("/v1/all")
    public List<StudentResponse> findAll() {
        return studentRestMapper.toStudentResponses(studentServicePort.findAll());
    }

    @GetMapping("/v1/{id}")
    public StudentResponse findById(
            @PathVariable Long id
    ) {
        return studentRestMapper.toStudentResponse(studentServicePort.findById(id));
    }

    @PostMapping("/v1")
    public ResponseEntity<StudentResponse> create(
            @Valid @RequestBody StudentCreateRequest studentCreateRequest
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentRestMapper.toStudentResponse(studentServicePort.save(studentRestMapper.toStudent(studentCreateRequest))));
    }

    @PutMapping("/v1/{id}")
    public ResponseEntity<StudentResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody StudentUpdateRequest studentUpdateRequest
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(studentRestMapper.toStudentResponse(studentServicePort.update(id, studentRestMapper.toStudent(studentUpdateRequest))));
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        studentServicePort.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
