package com.iagica.training.plannerrest.domain.dto.request;

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
public class AgendaDisponibilitaRequest {
    Integer id;
    LocalDate masterDate;
    LocalDate masterEndDate;
    LocalTime startEventTime;
    LocalTime endEventTime;
    boolean eventPublic;
    Integer user;
}
