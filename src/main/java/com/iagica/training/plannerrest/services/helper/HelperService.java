package com.iagica.training.plannerrest.services.helper;

import com.iagica.training.plannerrest.domain.dto.request.EventTypeRequest;
import com.iagica.training.plannerrest.domain.dto.response.EventTypeResponse;
import com.iagica.training.plannerrest.domain.exception.NotFoundException;
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

    public List<EventTypeResponse> findAllEventType() throws Exception {
        return eventTypeRepository.findAll().stream().map(eventType -> {
            var eventTypeResponse = new EventTypeResponse(eventType.getUidenventtype(), eventType.getEventname(), eventType.getDuration());
            return eventTypeResponse;
        }).collect(Collectors.toList());
    }

    public EventTypeResponse findByIdEventType(Integer id) {
        Optional<EventType> eventType = eventTypeRepository.findById(id);
        if (!eventType.isEmpty()) {
            return new EventTypeResponse(eventType.get().getUidenventtype(), eventType.get().getEventname(), eventType.get().getDuration());
        }
        throw new NotFoundException(String.format("EntityType with id=%d", id.intValue()));
    }

    public void saveEventType(EventTypeRequest request)  {
        eventTypeRepository.save(new EventType(null, request.getEventName(), request.getDuration()));
    }
}
