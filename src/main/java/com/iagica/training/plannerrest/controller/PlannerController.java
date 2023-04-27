package com.iagica.training.plannerrest.controller;



import com.iagica.training.plannerrest.domain.dto.request.AgendaDisponibilitaRequest;
import com.iagica.training.plannerrest.domain.dto.request.AgendaRequest;
import com.iagica.training.plannerrest.domain.dto.request.EventRequest;
import com.iagica.training.plannerrest.domain.dto.response.AgendaResponse;
import com.iagica.training.plannerrest.domain.dto.response.EventResponse;
import com.iagica.training.plannerrest.services.planner.PlannerService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/planner")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class PlannerController {



    private final PlannerService plannerService;
    @GetMapping("/event/findAll")
        public ResponseEntity<List<EventResponse>> eventFindAll() throws Exception {
            return ResponseEntity.ok(plannerService.findAll());
    }

    @GetMapping("/event/findById/{id}")
        public ResponseEntity<EventResponse> eventFindById(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(plannerService.findById(id));
    }

    @PostMapping("/event/insert")
        public ResponseEntity<?> eventInsert(@RequestBody EventRequest eventRequest) throws Exception {
        plannerService.insertEvent(eventRequest);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/event/delete/{id}")
        public ResponseEntity<?> eventDelete(@PathVariable Integer id) throws Exception {
        plannerService.deleteEvent(id);
        return ResponseEntity.ok(null);
    }

    @PutMapping("event/update")
        public ResponseEntity<?> eventEdit(@RequestBody EventRequest eventRequest) throws Exception {
        plannerService.updateEvent(eventRequest);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/agenda/findAll")
    public ResponseEntity<List<AgendaResponse>> findAll()throws Exception{
        return ResponseEntity.ok(plannerService.findAllAgenda());
    }

    @PostMapping("/agenda/findByOrari")
    public ResponseEntity<List<AgendaResponse>> findByOrary(@RequestBody AgendaDisponibilitaRequest agendaRequest)throws Exception{
        return ResponseEntity.ok(plannerService.findAgendaByOrari(agendaRequest));
    }

    @PostMapping("/agenda/insertAgenda")
    public ResponseEntity<?> insertAgenda(@RequestBody AgendaRequest agendaRequest)throws Exception{
        plannerService.insertAgenda(agendaRequest);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/agenda/delete/{id}")
    public ResponseEntity<?> deleteAgenda(@PathVariable Integer id)throws Exception{
        plannerService.deleteAgenda(id);
        return ResponseEntity.ok(null);
    }

}
