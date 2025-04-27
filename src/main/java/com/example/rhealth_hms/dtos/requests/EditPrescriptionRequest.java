package com.example.rhealth_hms.dtos.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EditPrescriptionRequest {

    @NotNull(message = "Prescription ID is required")
    private Long prescriptionId;

    @NotEmpty(message = "Items are required")
    private List<EditPrescriptionItem> items;
}
