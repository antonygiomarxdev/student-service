package com.services.ms.student.student_service.domain.model;


import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Long id;

    private String firstName;

    private String lastName;

    private Integer age;

    private String address;
}
