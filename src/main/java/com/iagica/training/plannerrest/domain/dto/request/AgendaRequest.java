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
public class AgendaRequest {
    Integer uidAgenda;
    LocalDate masterDate;
    LocalTime startEventTime;
    LocalTime eventExpired;
    String eventPublic;
    EventRequest event;

}
