package com.example.rhealth_hms.dtos.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrescriptionDrugRequest {

    @NotNull(message = "Drug ID is required")
    private Long drugId;

    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;

    private String note;
}
