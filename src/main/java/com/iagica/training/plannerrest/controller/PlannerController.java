package com.iagica.training.plannerrest.controller;

import com.iagica.training.plannerrest.domain.dto.request.EventRequest;
import com.iagica.training.plannerrest.domain.dto.response.EventResponse;
import com.iagica.training.plannerrest.services.planner.PlannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/planner")
@RequiredArgsConstructor
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

}
