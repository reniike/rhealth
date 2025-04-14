package com.example.rhealth_hms.data.repositories;

import com.example.rhealth_hms.data.models.Queue;
import com.example.rhealth_hms.data.models.enums.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QueueRepository extends JpaRepository<Queue, Long> {

    List<Queue> findAllByDepartmentAndStaff_StaffId(Department department, String staffStaffId);

    List<Queue> findByDepartment(Department department);
}
