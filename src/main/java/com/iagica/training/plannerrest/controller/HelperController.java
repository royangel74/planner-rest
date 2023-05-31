package com.iagica.training.plannerrest.controller;

import com.iagica.training.plannerrest.domain.dto.request.EventTypeRequest;
import com.iagica.training.plannerrest.domain.dto.request.RefreshTokenRequest;
import com.iagica.training.plannerrest.domain.dto.response.AuthenticationResponse;
import com.iagica.training.plannerrest.domain.dto.response.EventTypeResponse;
import com.iagica.training.plannerrest.domain.dto.response.UserResponse;
import com.iagica.training.plannerrest.domain.model.helper.User;
import com.iagica.training.plannerrest.services.helper.AuthenticationService;
import com.iagica.training.plannerrest.services.helper.HelperService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/helper")
@RequiredArgsConstructor
public class HelperController extends RestrictedController {

    private final AuthenticationService service;
    private final HelperService helperService;

    /*
    @PostMapping("/refresh-token")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response ) throws IOException {
        service.refreshToken(request, response);
    }

     */
    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken2(@RequestBody RefreshTokenRequest refreshTokenRequest) throws IOException {

        return ResponseEntity.ok(service.refreshToken(refreshTokenRequest));
    }

    @GetMapping("/eventType")
    public ResponseEntity<List<EventTypeResponse>> EventTypeFindAll() throws Exception {
        return ResponseEntity.ok(helperService.findAll());
    }

    @GetMapping("/eventType/{id}")
    public ResponseEntity<EventTypeResponse> eventTypeFindById(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(helperService.findById(id));
    }

    @PostMapping("/evenType/insert")
    @PreAuthorize("this.hasPrevilege(authentication)")
    public ResponseEntity<?> eventTypeInsert(@RequestBody EventTypeRequest eventTypeRequest) throws Exception {
        helperService.insertEventType(eventTypeRequest);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/eventType/delete/{id}")
    public ResponseEntity<?> eventTypeDelete(@PathVariable Integer id) throws Exception {
        helperService.deleteEventType(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/eventType/findByEventName/{name}")
    public ResponseEntity<EventTypeResponse> eventTypeFindName(@PathVariable String name) throws Exception {
        return  ResponseEntity.ok(helperService.findEventTypeByName(name));
    }

    @PutMapping("/eventType/editEventType")
    public ResponseEntity<?> eventTypeEdete(@RequestBody EventTypeRequest eventTypeRequest) throws Exception {
        helperService.putEventType(eventTypeRequest);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/user/findByEmail/{email}")
    public ResponseEntity<UserResponse> findUserByEmail(@PathVariable String email) throws Exception{
       return ResponseEntity.ok(helperService.findUserByEmail(email));
    }
}
