package com.example.rhealth_hms.dtos;

import com.example.rhealth_hms.data.models.enums.PrescriptionStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PrescriptionDTO {

    private Long id;

    private UserDTO staff;

    private PatientDTO patient;

    private SessionDTO session;

    private PrescriptionStatus prescriptionStatus;

    private List<PrescriptionItemDTO> items;
}
