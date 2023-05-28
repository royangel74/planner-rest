package com.iagica.training.plannerrest.controller;

import com.iagica.training.plannerrest.domain.dto.request.EventTypeRequest;
import com.iagica.training.plannerrest.domain.dto.response.EventTypeResponse;
import com.iagica.training.plannerrest.services.helper.AuthenticationService;
import com.iagica.training.plannerrest.services.helper.HelperService;
import com.iagica.training.plannerrest.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event")
@RequiredArgsConstructor
public class EventController extends RestrictedController {

    private final HelperService helperService;

    @PreAuthorize("this.hasPrivilege(authentication, 'READ')")
    @GetMapping("/eventType")
    public ResponseEntity<List<EventTypeResponse>> findAllEventType() throws Exception {
        return ResponseEntity.ok(helperService.findAllEventType());
    }

    @PreAuthorize("this.hasPrivilege(authentication, 'READ')")
    @GetMapping("/eventType/{id}")
    public ResponseEntity<EventTypeResponse> findByIdEventType(@PathVariable Integer id) {
        return ResponseEntity.ok(helperService.findByIdEventType(id));
    }

    @PreAuthorize("this.hasPrivilege(authentication, 'WRITE')")
    @PutMapping("/eventType")
    public void saveEventType(@RequestBody EventTypeRequest eventType) {
        helperService.saveEventType(eventType);
    }

    @Override
    public String getPreauthorizeIdFunction() {
        return Constants.EVENT_CONTROLLER_FUNCTION;
    }
}
