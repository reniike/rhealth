package com.example.rhealth_hms.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDiagnosisRequest {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Note is required")
    private String note;

    @NotNull(message = "Session ID is required")
    private Long sessionId;

}
