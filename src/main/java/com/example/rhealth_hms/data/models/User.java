package com.example.rhealth_hms.data.models;

import com.example.rhealth_hms.data.models.enums.Department;
import com.example.rhealth_hms.data.models.enums.StaffStatus;
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
@Table(name = "users")
public class User extends IdEntity {

    @Column(name = "staff_id", unique = true)
    private String staffId;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phone", unique = true, nullable = false)
    private String phone;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StaffStatus status;

    @Enumerated
    @Column(name = "department_id", nullable = false)
    private Department department;
}
