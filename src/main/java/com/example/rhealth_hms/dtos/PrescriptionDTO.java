package com.example.rhealth_hms.dtos;

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

    private List<PrescriptionItemDTO> items;
}
