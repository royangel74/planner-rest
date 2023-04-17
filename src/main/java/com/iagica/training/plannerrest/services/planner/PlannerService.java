package com.iagica.training.plannerrest.services.planner;
import com.iagica.training.plannerrest.domain.dto.request.EventRequest;
import com.iagica.training.plannerrest.domain.dto.response.EventResponse;
import com.iagica.training.plannerrest.domain.model.helper.EventType;
import com.iagica.training.plannerrest.domain.model.helper.User;
import com.iagica.training.plannerrest.domain.model.planner.Event;
import com.iagica.training.plannerrest.repository.planner.EventRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlannerService {

    @Autowired
    ModelMapper modelMapper;
    private final EventRepository eventRepository;

    public List<EventResponse> findAll() throws Exception {
        return eventRepository.findAll().stream().map(event -> {
            var eventResponse = new EventResponse(event.getId(), event.getDescription(), event.getUser().getFirstname(), event.getUser().getLastname());
            return eventResponse;
        }).collect(Collectors.toList());
    }

    public EventResponse findById(Integer id) throws Exception {
        Optional<Event> event = eventRepository.findById(id);
        if (!event.isEmpty()) {
            return new EventResponse(event.get().getId(), event.get().getDescription(), event.get().getUser().getFirstname(), event.get().getUser().getLastname());
        }
        return null;
    }

    public void insertEvent(EventRequest eventRequest) throws Exception {
        Event event = modelMapper.map(eventRequest, Event.class);
        event.setCreatedAt(LocalDateTime.now());

        eventRepository.save(event);
    }

    public void deleteEvent(Integer id) throws Exception {
        Optional<Event> event = eventRepository.findById(id);

        if (!event.isEmpty()) {
            eventRepository.delete(event.get());
        } else {
            throw new Exception(String.format("L'id evento %s è inesistente", id));
        }
    }

    public void updateEvent(EventRequest eventRequest) throws Exception {
        Optional<Event> eventResponse = eventRepository.findById(eventRequest.getId());
        Event event = modelMapper.map(eventRequest, Event.class);
        event.setCreatedAt(eventResponse.get().getCreatedAt());
        event.setModifiedAt(LocalDateTime.now());

        if (!eventResponse.isEmpty()) {
            eventRepository.save(event);
        } else {
            throw new Exception("La modifica non è andata a buon fine");
        }
    }

}
