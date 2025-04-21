package com.example.rhealth_hms.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "prescription_items")
public class PrescriptionItem extends IdEntity{

    @ManyToOne(optional = false)
    private Prescription prescription;

    @ManyToOne(optional = false)
    private Drug drug;

    private int quantity;

    private String note;
}
