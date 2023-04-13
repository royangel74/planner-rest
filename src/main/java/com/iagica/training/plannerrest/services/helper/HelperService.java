package com.iagica.training.plannerrest.services.helper;

import com.iagica.training.plannerrest.domain.dto.request.EventTypeRequest;
import com.iagica.training.plannerrest.domain.dto.response.EventTypeResponse;
import com.iagica.training.plannerrest.domain.model.helper.EventType;
import com.iagica.training.plannerrest.repository.helper.EventTypeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HelperService {

    @Autowired
    ModelMapper modelMapper;
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

    public void insertEventType(EventTypeRequest eventTypeRequest) throws Exception {
        List<EventType> listEventTypes = eventTypeRepository.findAll();
        boolean verified = listEventTypes.stream()
                .noneMatch(e -> e.getEventName().equals(eventTypeRequest.getEventName()));

        EventType eventType = modelMapper.map(eventTypeRequest, EventType.class);

        if (verified) {
            eventTypeRepository.save(eventType);
        } else {
            throw new Exception("Il tipo di evento è già presente");
        }
    }

    public void deleteEventType(Integer id) throws Exception {
        Optional<EventType> eventType = eventTypeRepository.findById(id);
        if (!eventType.isEmpty()) {
            eventTypeRepository.delete(eventType.get());
        } else {
            throw new Exception("L'evento risulta non esistente");
        }
    }

    public EventTypeResponse findEventTypeByName(String eventName) throws Exception {
        Optional<EventType> eventType = eventTypeRepository.findByEventName(eventName);
        if (!eventType.isEmpty()) {
            var eventTypeResponse = new EventTypeResponse(eventType.get().getId(), eventType.get().getEventName());
            return eventTypeResponse;
        } else {
            throw new Exception("La ricerca non ha prodotto risultati");
        }
    }

    public void putEventType(EventTypeRequest eventTypeRequest) throws Exception {
        Optional<EventType> eventTypeResponse = eventTypeRepository.findById(eventTypeRequest.getId());
        EventType eventType = modelMapper.map(eventTypeRequest, EventType.class);

        if (!eventTypeResponse.isEmpty()) {
            eventTypeRepository.save(eventType);
        } else {
            throw new Exception("La modifica non è andata a buon fine");
        }
    }
}
