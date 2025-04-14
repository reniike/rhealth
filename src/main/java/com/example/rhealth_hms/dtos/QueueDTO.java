package com.example.rhealth_hms.dtos;

import com.example.rhealth_hms.data.models.enums.Department;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class QueueDTO {

    private Long queueId;

    private String patientId;

    private String patientName;

    private String staffId;

    private String recipientId;

    private Department department;

    private LocalDateTime createdAt;
}
