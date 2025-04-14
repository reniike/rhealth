package com.example.rhealth_hms.data.models;

import com.example.rhealth_hms.data.models.enums.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "queues")
public class Queue extends IdEntity{

    @ManyToOne(optional = false)
    private Patient patient;

    @ManyToOne(optional = false)
    private User staff;

    @ManyToOne(optional = false)
    private Session session;

    @ManyToOne(optional = false)
    private User recipient;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Department department;
}
