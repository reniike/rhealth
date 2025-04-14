package com.example.rhealth_hms.services;

import com.example.rhealth_hms.dtos.QueueDTO;
import com.example.rhealth_hms.dtos.requests.CreateQueueRequest;

public interface QueueService {

    QueueDTO addToQueue(CreateQueueRequest request);
}
