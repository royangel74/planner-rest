package com.iagica.training.plannerrest.domain.dto.response;

import com.iagica.training.plannerrest.domain.dto.request.UserRequest;
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
public class EventResponse {
    Integer id;
    String description;
    EventTypeResponse eventType;
    UserResponse user;


}
