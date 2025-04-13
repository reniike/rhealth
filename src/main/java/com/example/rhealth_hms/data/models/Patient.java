package com.example.rhealth_hms.data.models;

import com.example.rhealth_hms.data.models.enums.BloodGroup;
import com.example.rhealth_hms.data.models.enums.Genotype;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "patients")
public class Patient extends IdEntity{

    @Column(nullable = false, unique = true)
    private String patientId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genotype genotype;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BloodGroup bloodGroup;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String emergencyContact;
}
