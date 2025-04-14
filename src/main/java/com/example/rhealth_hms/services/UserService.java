package com.example.rhealth_hms.services;

import com.example.rhealth_hms.data.models.User;
import jakarta.validation.constraints.NotBlank;

public interface UserService {

    User getUserByStaffId(@NotBlank(message = "Recipient ID is required") String staffId);
}
