package com.iagica.training.plannerrest.repositorytest;

import com.iagica.training.plannerrest.PlannerRestApplication;
import com.iagica.training.plannerrest.repository.planner.EventRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = PlannerRestApplication.class)
public class EventRepositoryTests {

    @Autowired
    EventRepository eventRepository;


}
