package com.example.rhealth_hms.dtos;

import com.example.rhealth_hms.data.models.enums.BloodGroup;
import com.example.rhealth_hms.data.models.enums.Genotype;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PatientDTO {

    private String patientId;

    private String firstName;

    private String lastName;

    private String phone;

    private LocalDate dateOfBirth;

    private Genotype genotype;

    private BloodGroup bloodGroup;

    private String address;

    private String emergencyContact;

}
