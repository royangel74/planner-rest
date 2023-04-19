package com.iagica.training.plannerrest.domain.dto.response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AgendaResponse {

    Integer id;
    LocalDate masterDate;
    LocalTime startEventTime;
    LocalTime endEventTime;
    boolean eventPublic;
    EventResponse event;




}
