package com.example.rhealth_hms.services;

import com.example.rhealth_hms.data.models.Drug;
import jakarta.validation.constraints.NotNull;

public interface DrugService {

    Drug getDrug(@NotNull(message = "Drug ID is required") Long drugId);

}
