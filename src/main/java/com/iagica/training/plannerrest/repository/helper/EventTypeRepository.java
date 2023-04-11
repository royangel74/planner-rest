package com.iagica.training.plannerrest.repository.helper;

import com.iagica.training.plannerrest.domain.model.helper.EventType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventTypeRepository extends JpaRepository <EventType, Integer> {
}
