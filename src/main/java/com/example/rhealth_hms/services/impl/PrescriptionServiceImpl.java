package com.example.rhealth_hms.services.impl;

import com.example.rhealth_hms.data.models.*;
import com.example.rhealth_hms.data.models.enums.Department;
import com.example.rhealth_hms.data.models.enums.PrescriptionStatus;
import com.example.rhealth_hms.data.repositories.PrescriptionRepository;
import com.example.rhealth_hms.dtos.PrescriptionDTO;
import com.example.rhealth_hms.dtos.requests.AbstractPrescriptionItemRequest;
import com.example.rhealth_hms.dtos.requests.EditPrescriptionRequest;
import com.example.rhealth_hms.dtos.requests.PrescriptionRequest;
import com.example.rhealth_hms.exceptions.RhealthException;
import com.example.rhealth_hms.mappers.PrescriptionMapper;
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
    private final PrescriptionMapper prescriptionMapper;
    private final PrescriptionRepository repository;
    private final DrugService drugService;
    private final SessionService sessionService;

    @Override
    public PrescriptionDTO createPrescription(PrescriptionRequest request) {
        User user = userService.getCurrentUser();

        if (!user.getDepartment().equals(Department.DOCTOR)) {
            throw new RhealthException(UNAUTHORIZED);
        }

        Session session = sessionService.getSessionById(request.getSessionId());

        Prescription prescription = Prescription.builder()
                .staff(user)
                .patient(session.getPatient())
                .session(session)
                .prescriptionStatus(PrescriptionStatus.PENDING)
                .build();

        List<PrescriptionItem> items = buildPrescriptionItems(prescription, request.getItems());
        prescription.setItems(items);

        repository.save(prescription);

        return mapper.map(prescription, PrescriptionDTO.class);
    }

    @Override
    public PrescriptionDTO editPrescription(EditPrescriptionRequest request) {
        User user = userService.getCurrentUser();

        if (!user.getDepartment().equals(Department.DOCTOR)) {
            throw new RhealthException(UNAUTHORIZED);
        }

        Prescription prescription = repository.findById(request.getPrescriptionId())
                .orElseThrow(() -> new RhealthException(NOT_FOUND));

        if (prescription.getPrescriptionStatus().equals(PrescriptionStatus.FULFILLED)) {
            throw new RhealthException("Cannot edit. Prescription already fulfilled.");
        }

        prescription.getItems().clear();

        List<PrescriptionItem> updatedItems = buildPrescriptionItems(prescription, request.getItems());
        prescription.setItems(updatedItems);

        repository.save(prescription);

        return mapper.map(prescription, PrescriptionDTO.class);
    }

    @Override
    public void deletePrescription(Long id) {
        User user = userService.getCurrentUser();

        if (!user.getDepartment().equals(Department.DOCTOR)) {
            throw new RhealthException(UNAUTHORIZED);
        }

        Prescription prescription = repository.getPrescriptionById(id)
                .orElseThrow(() -> new RhealthException(NOT_FOUND));

        if (prescription.getPrescriptionStatus().equals(PrescriptionStatus.FULFILLED)) {
            throw new RhealthException("Prescription already fulfilled. Cannot delete.");
        }

        repository.deleteById(id);
    }

    @Override
    public PrescriptionDTO getPrescriptionBySessionId(Long sessionId) {
        Prescription prescription = repository.getPrescriptionBySession_Id(sessionId)
                .orElseThrow(() -> new RhealthException("Prescription not found for session ID: " + sessionId));

        return prescriptionMapper.toDTO(prescription);
    }

    @Override
    public List<PrescriptionDTO> getPrescriptionsByPatientId(Long patientId) {
        List<Prescription> prescriptions = repository.findAllByPatient_Id(patientId);
        return prescriptionMapper.toDTOs(prescriptions);
    }

    /**
     * Builds PrescriptionItem entities from request items
     */
    private List<PrescriptionItem> buildPrescriptionItems(Prescription prescription, List<? extends AbstractPrescriptionItemRequest> itemRequests) {
        return itemRequests.stream()
                .map(itemRequest -> {
                    Drug drug = drugService.getDrug(itemRequest.getDrugId());
                    return PrescriptionItem.builder()
                            .prescription(prescription)
                            .drug(drug)
                            .quantity(itemRequest.getQuantity())
                            .note(itemRequest.getNote())
                            .build();
                })
                .toList();
    }
}
