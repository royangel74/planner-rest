package com.iagica.training.plannerrest.services.helper;

import com.iagica.training.plannerrest.domain.dto.request.EventTypeRequest;
import com.iagica.training.plannerrest.domain.dto.response.EventTypeResponse;
import com.iagica.training.plannerrest.domain.exception.NotFoundException;
import com.iagica.training.plannerrest.domain.exception.DuplicateException;
import com.iagica.training.plannerrest.domain.model.helper.EventType;
import com.iagica.training.plannerrest.repository.helper.EventTypeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

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
            var eventTypeResponse = new EventTypeResponse(eventType.getUidEventType(), eventType.getEventName());
            return eventTypeResponse;
        }).collect(Collectors.toList());
    }

    public EventTypeResponse findById(Integer id) throws Exception{
        Optional<EventType> eventType = eventTypeRepository.findById(id);
        if (!eventType.isEmpty()) {
            return new EventTypeResponse(eventType.get().getUidEventType(), eventType.get().getEventName());
        }
        throw new NotFoundException(String.format("Event-Type whit ID: %s non presente ",id.intValue()));
    }

    public void insertEventType(EventTypeRequest eventTypeRequest) throws Exception {

        List<EventType> listEventTypes = eventTypeRepository.findAll();
        boolean verified = listEventTypes.stream()
                .noneMatch(e -> e.getEventName().equals(eventTypeRequest.getEventName()));

        EventType eventType = modelMapper.map(eventTypeRequest, EventType.class);

        if (verified) {
            eventTypeRepository.save(eventType);
        } else {
            throw new DuplicateException(String.format("Type-Event con eventName: %s è già presente",eventTypeRequest.getEventName()));
        }
    }

    public void deleteEventType(Integer id) throws Exception {
        Optional<EventType> eventType = eventTypeRepository.findById(id);
        if (!eventType.isEmpty()) {
            eventTypeRepository.delete(eventType.get());
        } else {
            throw new NotFoundException(String.format("Event-Type whit ID: %s non presente ",id.intValue()));
        }
    }

    public EventTypeResponse findEventTypeByName(String eventName) throws Exception {
        Optional<EventType> eventType = eventTypeRepository.findByEventName(eventName);
        if (!eventType.isEmpty()) {
            var eventTypeResponse = new EventTypeResponse(eventType.get().getUidEventType(), eventType.get().getEventName());
            return eventTypeResponse;
        } else {
            throw new NotFoundException(String.format("Event-Type whit EventName: %s non presente ",eventName));
        }
    }

    public void putEventType(EventTypeRequest eventTypeRequest) throws Exception {
        Optional<EventType> eventTypeResponse = eventTypeRepository.findById(eventTypeRequest.getUidEventType());
        EventType eventType = modelMapper.map(eventTypeRequest, EventType.class);

        if (!eventTypeResponse.isEmpty()) {
            if(!eventTypeResponse.get().getEventName().equals(eventTypeRequest.getEventName())){
                eventTypeRepository.save(eventType);
            }else{

                throw new DuplicateException(String.format("Event-Type con valore EventName: %s è gia presente",eventTypeRequest.getEventName()));
            }
        } else {
            throw new NotFoundException(String.format("Event-Type con ID: %s non è presente",eventTypeRequest.getUidEventType()));
        }
    }
}
