package com.example.rhealth_hms.mappers;

import com.example.rhealth_hms.data.models.Prescription;
import com.example.rhealth_hms.data.models.PrescriptionItem;
import com.example.rhealth_hms.dtos.PrescriptionDTO;
import com.example.rhealth_hms.dtos.PrescriptionItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PrescriptionMapper {

    PrescriptionDTO toDTO(Prescription prescription);

    @Mapping(source = "drug.id", target = "drugId")
    @Mapping(source = "drug.name", target = "drugName")
    @Mapping(source = "prescriptionStatus", target = "prescriptionStatus")
    PrescriptionItemDTO toDTO(PrescriptionItem item);

    List<PrescriptionDTO> toDTOs(List<Prescription> prescriptions);
}

