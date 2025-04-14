package com.example.rhealth_hms.controller;

import com.example.rhealth_hms.dtos.QueueDTO;
import com.example.rhealth_hms.dtos.requests.CreateQueueRequest;
import com.example.rhealth_hms.services.QueueService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/queue")
public class QueueController {

    private QueueService queueService;

    @PostMapping
    public ResponseEntity<QueueDTO> addToQueue(@Valid @RequestBody CreateQueueRequest request){
        return ResponseEntity.ok(queueService.addToQueue(request));
    }
}
