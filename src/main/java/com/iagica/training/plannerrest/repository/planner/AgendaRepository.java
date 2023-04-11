package com.iagica.training.plannerrest.repository.planner;

import com.iagica.training.plannerrest.domain.model.planner.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<Agenda, Integer> {
}
