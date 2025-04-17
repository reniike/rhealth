package com.example.rhealth_hms.dtos;

import com.example.rhealth_hms.data.models.enums.SessionStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class SessionDTO {

    private Long id;

    private PatientDTO patient;

    private SessionStatus status;

    private UserDTO staff;

    private LocalDate startedAt;

    private LocalDate endedAt;
}
