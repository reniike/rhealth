package com.example.rhealth_hms.dtos.requests;

import com.example.rhealth_hms.data.models.enums.Department;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateQueueRequest {

    @NotNull(message = "Patient ID is required")
    private Long patientId;

    @NotNull(message = "Recipient ID is required")
    private Long recipientId;

    @NotNull(message = "Department is required")
    private Department department;

}
