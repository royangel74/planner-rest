package com.iagica.training.plannerrest.repository.planner;

import com.iagica.training.plannerrest.domain.dto.request.AgendaDisponibilitaRequest;
import com.iagica.training.plannerrest.domain.dto.request.AgendaRequest;
import com.iagica.training.plannerrest.domain.model.planner.Agenda;

import java.util.List;

public interface AgendaRepositoryCustom {

    public List<Agenda> findByAgenda(AgendaDisponibilitaRequest agendaRequest);



}
