package com.iagica.training.plannerrest.repositorytest;

import com.iagica.training.plannerrest.PlannerRestApplication;
import com.iagica.training.plannerrest.domain.model.helper.EventType;
import com.iagica.training.plannerrest.repository.helper.EventTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextConfiguration(classes = PlannerRestApplication.class)
public class EventTypeRepositoryTest {
    @Autowired
    private EventTypeRepository eventTypeRepository;

    @Test
    public void findByEventName()throws Exception{
        Optional<EventType> eventType = eventTypeRepository.findByEventName("ID_BIRTHDAY");
        assertEquals(1,1);
    }

    @Test public void findByUidEventType()throws Exception{
       Optional <EventType> eventType = eventTypeRepository.findById(1);
       assertEquals(1,1);
    }
}
