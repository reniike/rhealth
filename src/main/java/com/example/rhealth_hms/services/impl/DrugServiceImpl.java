package com.example.rhealth_hms.services.impl;

import com.example.rhealth_hms.data.models.Drug;
import com.example.rhealth_hms.data.repositories.DrugRepository;
import com.example.rhealth_hms.exceptions.RhealthException;
import com.example.rhealth_hms.services.DrugService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.rhealth_hms.utils.AppUtils.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class DrugServiceImpl implements DrugService {

    private final DrugRepository repository;

    @Override
    public Drug getDrug(Long drugId) {
        return repository.getDrugById(drugId).orElseThrow(()-> new RhealthException(NOT_FOUND));
    }
}
