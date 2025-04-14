package com.example.rhealth_hms.services.impl;

import com.example.rhealth_hms.data.models.User;
import com.example.rhealth_hms.data.repositories.UserRepository;
import com.example.rhealth_hms.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public User getUserByStaffId(String staffId) {
        return repository.findByStaffId(staffId);
    }
}
