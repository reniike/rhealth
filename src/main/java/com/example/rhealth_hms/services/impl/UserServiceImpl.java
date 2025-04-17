package com.example.rhealth_hms.services.impl;

import com.example.rhealth_hms.data.models.User;
import com.example.rhealth_hms.data.repositories.UserRepository;
import com.example.rhealth_hms.dtos.UserDTO;
import com.example.rhealth_hms.exceptions.RhealthException;
import com.example.rhealth_hms.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import static com.example.rhealth_hms.utils.AppUtils.NOT_FOUND;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final ModelMapper mapper;

    @Override
    public User getUserById(Long staffId) {
        return repository.findById(staffId).orElseThrow(() -> new RhealthException(NOT_FOUND));
    }

    @Override
    public UserDTO getUser(Long userId) {
        User user = repository.findById(userId).orElseThrow(() -> new RhealthException(NOT_FOUND));
        return mapper.map(user, UserDTO.class);
    }

    @Override
    public User getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        return repository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new RhealthException("Logged in user not found"));
    }


}
