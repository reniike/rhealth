package com.example.rhealth_hms.data.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "prescriptions")
public class Prescription extends IdEntity{

    @ManyToOne(optional = false)
    private Session session;

    @ManyToOne(optional = false)
    private Patient patient;

    @ManyToOne(optional = false)
    private User staff;

    @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL)
    private List<PrescriptionItem> items;
}
