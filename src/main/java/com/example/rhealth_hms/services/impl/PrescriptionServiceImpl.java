package com.example.rhealth_hms.services.impl;

import com.example.rhealth_hms.data.models.*;
import com.example.rhealth_hms.data.models.enums.Department;
import com.example.rhealth_hms.data.repositories.PrescriptionItemRepository;
import com.example.rhealth_hms.data.repositories.PrescriptionRepository;
import com.example.rhealth_hms.dtos.PrescriptionDTO;
import com.example.rhealth_hms.dtos.PrescriptionItemDTO;
import com.example.rhealth_hms.dtos.requests.PrescriptionRequest;
import com.example.rhealth_hms.exceptions.RhealthException;
import com.example.rhealth_hms.services.DrugService;
import com.example.rhealth_hms.services.PrescriptionService;
import com.example.rhealth_hms.services.SessionService;
import com.example.rhealth_hms.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.rhealth_hms.utils.AppUtils.NOT_FOUND;
import static com.example.rhealth_hms.utils.AppUtils.UNAUTHORIZED;

@Service
@RequiredArgsConstructor
public class PrescriptionServiceImpl implements PrescriptionService {

    private final UserService userService;
    private final ModelMapper mapper;
    private final PrescriptionRepository repository;
    private final DrugService drugService;
    private final SessionService sessionService;
    private final PrescriptionItemRepository prescriptionItemRepository;

    @Override
    public PrescriptionDTO createPrescription(PrescriptionRequest request) {
        User user = userService.getCurrentUser();
        if (!user.getDepartment().equals(Department.DOCTOR)) throw new RhealthException(UNAUTHORIZED);
        Session session = sessionService.getSessionById(request.getSessionId());

        Prescription prescription = Prescription.builder()
                .staff(user)
                .patient(session.getPatient())
                .session(session)
                .build();

        List<PrescriptionItem> prescriptionItems = request.getItems().stream()
                .map(items -> {
                    Drug drug = drugService.getDrug(items.getDrugId());

                    return PrescriptionItem.builder()
                            .drug(drug)
                            .quantity(items.getQuantity())
                            .prescription(prescription)
                            .note(items.getNote())
                            .build();
                })
                .toList();

        prescriptionItemRepository.saveAll(prescriptionItems);

        prescription.setItems(prescriptionItems);
        repository.save(prescription);

        return mapper.map(prescription, PrescriptionDTO.class);
    }

    @Override
    public PrescriptionDTO getPrescriptionBySessionId(Long sessionId) {
        Prescription prescription = repository.getPrescriptionsBySession_Id(sessionId).orElseThrow(() -> new RhealthException(NOT_FOUND));
        List<PrescriptionItem> items = prescription.getItems();

        List<PrescriptionItemDTO> prescriptionItem = items.stream()
                .map(item -> mapper.map(item, PrescriptionItemDTO.class))
                .toList();

        PrescriptionDTO prescriptionDTO = mapper.map(prescription, PrescriptionDTO.class);
        prescriptionDTO.setItems(prescriptionItem);
        return prescriptionDTO;
    }
}
