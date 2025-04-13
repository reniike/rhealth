package com.example.rhealth_hms.mappers;

import com.example.rhealth_hms.data.models.Patient;
import com.example.rhealth_hms.dtos.PatientDTO;
import com.example.rhealth_hms.dtos.requests.CreatePatientRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    Patient toEntity(CreatePatientRequest request);

    PatientDTO toDTO(Patient patient);
}
