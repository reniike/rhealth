package com.example.rhealth_hms.data.models;

import com.example.rhealth_hms.data.models.enums.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment extends IdEntity {

    @ManyToOne(optional = false)
    private User staff;

    @ManyToOne(optional = false)
    private Patient patient;

    @Column(nullable = false)
    private String notes;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Department department;

    @Column(nullable = false)
    private LocalDate appointmentDate;
}
