package com.example.rhealth_hms.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiagnosisDTO {

    private String title;

    private String note;

    private PatientDTO patient;

    private SessionDTO session;

    private UserDTO staff;
}
