package com.example.rhealth_hms.services;

import com.example.rhealth_hms.data.models.User;
import com.example.rhealth_hms.dtos.UserDTO;
import jakarta.validation.constraints.NotBlank;

public interface UserService {

    User getUserById(@NotBlank(message = "Recipient ID is required") Long staffId);

    UserDTO getUser(Long userId);

    User getLoggedInUser();
}
