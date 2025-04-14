package com.example.rhealth_hms.services.impl;

import com.example.rhealth_hms.data.models.Patient;
import com.example.rhealth_hms.data.models.Queue;
import com.example.rhealth_hms.data.models.User;
import com.example.rhealth_hms.data.models.enums.Department;
import com.example.rhealth_hms.data.repositories.QueueRepository;
import com.example.rhealth_hms.dtos.QueueDTO;
import com.example.rhealth_hms.dtos.requests.CreateQueueRequest;
import com.example.rhealth_hms.mappers.QueueMapper;
import com.example.rhealth_hms.services.PatientService;
import com.example.rhealth_hms.services.QueueService;
import com.example.rhealth_hms.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class QueueServiceImpl implements QueueService {

    private final QueueRepository repository;
    private final QueueMapper mapper;
    private final PatientService patientService;
    private final UserService userService;


    @Override
    public QueueDTO addToQueue(CreateQueueRequest request) {

        Patient patient = patientService.getPatient(request.getPatientId());
        User recipient = userService.getUserByStaffId(request.getRecipientId());
        User staff = userService.getUserByStaffId(request.getStaffId());

        Queue queue = mapper.toEntity(request);
        queue.setRecipient(recipient);
        queue.setStaff(staff);
        queue.setPatient(patient);
        queue.setDepartment(request.getDepartment());

        return mapper.toDTO(repository.save(queue));
    }

    @Override
    public List<QueueDTO> getQueue(Department department, String staffId) {
        List<Queue> queues;

        if (staffId != null) {
            queues = repository.findAllByDepartmentAndStaff_StaffId(department, staffId);
        } else {
            queues = repository.findByDepartment(department);
        }

        return queues.stream().map(mapper::toDTO).toList();
    }
}
