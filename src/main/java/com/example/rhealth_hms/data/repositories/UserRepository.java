package com.example.rhealth_hms.data.repositories;

import com.example.rhealth_hms.data.models.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    boolean existsByEmailIgnoreCase(@NotBlank @Email String email);

    User findByStaffId(String staffId);
}
