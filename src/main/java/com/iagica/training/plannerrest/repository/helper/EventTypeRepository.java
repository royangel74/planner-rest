package com.iagica.training.plannerrest.repository.helper;

import com.iagica.training.plannerrest.domain.dto.request.EventTypeRequest;
import com.iagica.training.plannerrest.domain.dto.response.EventTypeResponse;
import com.iagica.training.plannerrest.domain.model.helper.EventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventTypeRepository extends JpaRepository <EventType, Integer> {
    public Optional<EventType> findByEventName(String eventName);
}
