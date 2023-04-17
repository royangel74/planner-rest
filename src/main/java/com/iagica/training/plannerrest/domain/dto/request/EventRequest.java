package com.iagica.training.plannerrest.domain.dto.request;

import com.iagica.training.plannerrest.domain.model.helper.EventType;
import com.iagica.training.plannerrest.domain.model.helper.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {
    Integer id;
    String description;
    EventType eventType;
    User user;
}
