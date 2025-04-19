package com.example.rhealth_hms.data.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "diagnoses")
public class Diagnosis extends IdEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String note;

    @ManyToOne(optional = false)
    private Patient patient;

    @ManyToOne(optional = false)
    private Session session;

    @ManyToOne(optional = false)
    private User staff;
}
