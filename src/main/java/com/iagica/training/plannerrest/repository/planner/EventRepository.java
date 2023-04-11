package com.iagica.training.plannerrest.repository.planner;

import com.iagica.training.plannerrest.domain.model.planner.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
