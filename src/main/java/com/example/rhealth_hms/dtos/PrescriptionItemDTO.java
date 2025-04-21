package com.example.rhealth_hms.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrescriptionItemDTO {

    private Long drugId;

    private String drugName;

    private int quantity;

    private String note;
}
