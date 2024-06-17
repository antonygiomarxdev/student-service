package com.services.ms.student.student_service.infrastructure.adapters.input.rest.model.request;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentUpdateRequest extends StudentCreateRequest {


    @NotNull(message = "Id is required")
    private Long id;


}
