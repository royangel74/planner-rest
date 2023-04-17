package com.iagica.training.plannerrest.domain.dto.response;

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
    String firstName;
    String lastName;
}
