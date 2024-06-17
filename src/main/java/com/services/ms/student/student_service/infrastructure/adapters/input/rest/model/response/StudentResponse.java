package com.services.ms.student.student_service.infrastructure.adapters.input.rest.model.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {

    private String firstName;
    private String lastName;
    private Integer age;
    private String address;
}
