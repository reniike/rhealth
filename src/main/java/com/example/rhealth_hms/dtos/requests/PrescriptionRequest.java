package com.example.rhealth_hms.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrescriptionRequest {

    @NotNull(message = "Drug ID is required")
    private Long drugId;

    @NotNull(message = "Session ID is required")
    private Long sessionId;

    private String note;
}
