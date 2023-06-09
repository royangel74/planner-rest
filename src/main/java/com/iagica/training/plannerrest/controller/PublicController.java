package com.iagica.training.plannerrest.controller;

import com.iagica.training.plannerrest.domain.dto.request.AuthenticationRequest;
import com.iagica.training.plannerrest.domain.dto.request.RegisterRequest;
import com.iagica.training.plannerrest.domain.dto.response.AuthenticationResponse;
import com.iagica.training.plannerrest.services.helper.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
@RequiredArgsConstructor
public class PublicController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register( @RequestBody RegisterRequest request ) {
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate( @RequestBody AuthenticationRequest request ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
