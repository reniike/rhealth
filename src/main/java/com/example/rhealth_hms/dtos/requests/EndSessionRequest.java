package com.example.rhealth_hms.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EndSessionRequest {

    @NotBlank(message = "Session ID is required")
    private Long sessionId;

}
