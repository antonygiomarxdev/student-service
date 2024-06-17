package com.services.ms.student.student_service.domain.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {


    private String errorCode;

    private String errorDescription;

    private List<String> details;

    private LocalDateTime timestamp;


}
