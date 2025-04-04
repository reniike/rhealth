package com.example.rhealth_hms.data.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prescriptions")
public class Prescription extends IdEntity{

    @ManyToOne(optional = false)
    private Drug drug;

    @ManyToOne(optional = false)
    private User staff;

    @ManyToOne(optional = false)
    private Session session;

    @ManyToOne(optional = false)
    private Patient patient;

    @Column(nullable = false)
    private String note;
}
