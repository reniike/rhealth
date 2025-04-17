package com.example.rhealth_hms.controller;

import com.example.rhealth_hms.data.models.enums.Department;
import com.example.rhealth_hms.dtos.QueueDTO;
import com.example.rhealth_hms.dtos.requests.CreateQueueRequest;
import com.example.rhealth_hms.services.QueueService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/queue")
public class QueueController {

    private final QueueService queueService;

    @PostMapping
    public ResponseEntity<QueueDTO> addToQueue(@Valid @RequestBody CreateQueueRequest request){
        return ResponseEntity.ok(queueService.addToQueue(request));
    }

    @GetMapping
    public ResponseEntity<List<QueueDTO>> getQueue(@RequestParam Department department, @RequestParam(required = false) String staffId){
        return ResponseEntity.ok(queueService.getQueue(department, staffId));
    }
}
