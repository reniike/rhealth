package com.example.rhealth_hms.dtos.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractPrescriptionItemRequest {

    @NotNull(message = "Drug ID is required")
    private Long drugId;

    @NotNull(message = "Quantity is required")
    private Integer quantity;

    private String note;

}
