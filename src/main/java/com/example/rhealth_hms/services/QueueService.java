package com.example.rhealth_hms.services;

import com.example.rhealth_hms.data.models.enums.Department;
import com.example.rhealth_hms.dtos.QueueDTO;
import com.example.rhealth_hms.dtos.requests.CreateQueueRequest;

import java.util.List;

public interface QueueService {

    QueueDTO addToQueue(CreateQueueRequest request);

    List<QueueDTO> getQueue(Department department, String staffId);
}
