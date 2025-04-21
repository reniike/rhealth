package com.example.rhealth_hms.services.impl;

import com.example.rhealth_hms.data.models.Drug;
import com.example.rhealth_hms.data.models.Prescription;
import com.example.rhealth_hms.data.models.User;
import com.example.rhealth_hms.data.models.enums.Department;
import com.example.rhealth_hms.data.repositories.PrescriptionRepository;
import com.example.rhealth_hms.dtos.PrescriptionDTO;
import com.example.rhealth_hms.dtos.requests.PrescriptionRequest;
import com.example.rhealth_hms.exceptions.RhealthException;
import com.example.rhealth_hms.services.DrugService;
import com.example.rhealth_hms.services.PrescriptionService;
import com.example.rhealth_hms.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrescriptionServiceImpl implements PrescriptionService {

    private final UserService userService;
    private ModelMapper mapper;
    private final PrescriptionRepository repository;
    private final DrugService drugService;

    @Override
    public PrescriptionDTO createPrescription(PrescriptionRequest request) {
        User user = userService.getCurrentUser();
        if (!user.getDepartment().equals(Department.DOCTOR)) throw new RhealthException("Unauthorized user");
        Drug drug = drugService.getDrug(request.getDrugId());
        Prescription prescription = Prescription.builder()
                .build();
        return null;
    }
}
