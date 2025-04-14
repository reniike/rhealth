package com.example.rhealth_hms.mappers;

import com.example.rhealth_hms.data.models.Queue;
import com.example.rhealth_hms.dtos.QueueDTO;
import com.example.rhealth_hms.dtos.requests.CreateQueueRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QueueMapper {

    QueueDTO toDTO(Queue queue);

    Queue toEntity(CreateQueueRequest request);

}
