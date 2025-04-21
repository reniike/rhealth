package com.example.rhealth_hms.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PrescriptionDTO {

    private DrugDTO drug;

    private UserDTO staff;

    private PatientDTO patient;

    private SessionDTO session;

    private String note;
}
