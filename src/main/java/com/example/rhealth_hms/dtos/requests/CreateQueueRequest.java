package com.example.rhealth_hms.dtos.requests;

import com.example.rhealth_hms.data.models.enums.Department;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateQueueRequest {

    @NotBlank(message = "Patient ID is required")
    private String patientId;

    @NotBlank(message = "Staff ID is required")
    private String staffId;

    @NotBlank(message = "Recipient ID is required")
    private String recipientId;

    @NotNull(message = "Department is required")
    private Department department;

}
