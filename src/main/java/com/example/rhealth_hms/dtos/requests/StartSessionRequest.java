package com.example.rhealth_hms.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StartSessionRequest {

    @NotBlank(message = "Patient ID is required")
    private Long patientId;

}
