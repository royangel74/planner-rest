package com.iagica.training.plannerrest.controller;


import com.iagica.training.plannerrest.service.Planner.PlannerService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/planner")
@RequiredArgsConstructor
public class PlannerController {

private final PlannerService plannerService;






}
