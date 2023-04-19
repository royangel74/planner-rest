package com.iagica.training.plannerrest.services.planner;
import com.iagica.training.plannerrest.domain.dto.request.*;
import com.iagica.training.plannerrest.domain.dto.response.AgendaResponse;
import com.iagica.training.plannerrest.domain.dto.response.EventResponse;

import com.iagica.training.plannerrest.domain.model.planner.Agenda;
import com.iagica.training.plannerrest.domain.model.planner.Event;
import com.iagica.training.plannerrest.repository.planner.AgendaRepository;
import com.iagica.training.plannerrest.repository.planner.EventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Log
@Service
@RequiredArgsConstructor
public class PlannerService {

    @Autowired
    ModelMapper modelMapper;
    private final EventRepository eventRepository;
    private final AgendaRepository agendaRepository;

    public List<EventResponse> findAll() throws Exception {
        return eventRepository.findAll().stream().map(event -> {
            EventResponse eventResponse = modelMapper.map(event,EventResponse.class);
            return eventResponse;
        }).collect(Collectors.toList());
    }

    public EventResponse findById(Integer id) throws Exception {
        Optional<Event> event = eventRepository.findById(id);
        if (!event.isEmpty()) {
            EventResponse eventResponse = modelMapper.map(event,EventResponse.class);
            return eventResponse;
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

    public List<AgendaResponse> findAllAgenda() throws Exception{
        return agendaRepository.findAll().stream().map(
                agenda -> {
                    AgendaResponse agendaResponse = modelMapper.map(agenda,AgendaResponse.class);
                    return agendaResponse;
                }
        ).collect(Collectors.toList());
    }

    public List<AgendaResponse> findAgendaByOrari(AgendaDisponibilitaRequest agendaRequest) throws Exception{
        List<Agenda> agenda = agendaRepository.findByAgenda(agendaRequest);
        List<AgendaResponse> agendaResponses = new ArrayList<>();
        if(!agenda.isEmpty()){
            agenda.stream().map(agenda1 -> {
                AgendaResponse agendaResponse = modelMapper.map(agenda1,AgendaResponse.class);
                agendaResponses.add(agendaResponse);
                return agendaResponse;
            }).collect(Collectors.toList());
        }
        return agendaResponses;
    }
}

