package com.example.rhealth_hms.data.models;

import com.example.rhealth_hms.data.models.enums.SessionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "sessions")
public class Session extends IdEntity{

    @ManyToOne(optional = false)
    private Patient patient;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SessionStatus status;

    @ManyToOne(optional = false)
    private User staff;

    @Column(nullable = false)
    private LocalDate startedAt = LocalDate.now();

    @Column(nullable = true)
    private LocalDate endedAt;
}

