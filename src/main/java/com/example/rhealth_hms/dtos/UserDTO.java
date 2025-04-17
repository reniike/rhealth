package com.example.rhealth_hms.dtos;

import com.example.rhealth_hms.data.models.enums.Department;
import com.example.rhealth_hms.data.models.enums.StaffStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class UserDTO {
    private Long id;
    private String staffId;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private StaffStatus status;
    private Department department;
    private LocalDateTime createdAt;
}
