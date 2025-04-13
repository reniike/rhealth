package com.example.rhealth_hms.dtos.requests;

import com.example.rhealth_hms.data.models.enums.BloodGroup;
import com.example.rhealth_hms.data.models.enums.Genotype;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreatePatientRequest {

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Phone number is required")
    private String phone;

    @NotNull(message = "Date of birth is required")
    private LocalDate dateOfBirth;

    @NotNull(message = "Genotype is required")
    private Genotype genotype;

    @NotNull(message = "Blood group is required")
    private BloodGroup bloodGroup;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Emergency contact is required")
    private String emergencyContact;

}
