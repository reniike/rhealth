package com.example.rhealth_hms.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PrescriptionRequest {

    @NotNull(message = "Session ID is required")
    private Long sessionId;

    @NotEmpty(message = "At least one drug must be prescribed")
    private List<PrescriptionDrugRequest> items;
}
