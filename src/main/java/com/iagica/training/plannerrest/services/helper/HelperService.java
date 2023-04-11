package com.iagica.training.plannerrest.services.helper;

import com.iagica.training.plannerrest.domain.dto.response.EventTypeResponse;
import com.iagica.training.plannerrest.domain.model.helper.EventType;
import com.iagica.training.plannerrest.repository.helper.EventTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HelperService {

    private final EventTypeRepository eventTypeRepository;

    public List<EventTypeResponse> findAll() throws Exception {
        return eventTypeRepository.findAll().stream().map(eventType -> {
            var eventTypeResponse = new EventTypeResponse(eventType.getId(), eventType.getEventName());
            return eventTypeResponse;
        }).collect(Collectors.toList());
    }

    public EventTypeResponse findById(Integer id) throws Exception{
        Optional<EventType> eventType = eventTypeRepository.findById(id);
        if (!eventType.isEmpty()) {
            return new EventTypeResponse(eventType.get().getId(), eventType.get().getEventName());
        }
        return null;
    }
}
