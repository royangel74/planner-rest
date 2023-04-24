package com.iagica.training.plannerrest.controllertest;

import com.iagica.training.plannerrest.PlannerRestApplication;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ContextConfiguration(classes = PlannerRestApplication.class)
public class EventTypeSelectTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;
    @BeforeEach
    public void setup() throws JSONException, IOException
    {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .build();
    }
    String JsonEventType = "    {\n" +
            "        \"uidEventType\": 2,\n" +
            "        \"eventName\": \"ID_MEETING\"\n" +
            "    },";

    @Test
    @Order(1)
    public void EventTypeById()throws Exception{
   mockMvc.perform(MockMvcRequestBuilders.get("/api/helper/eventType/2")
           .accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
           .andExpect(content().json(JsonEventType))
           .andReturn();

    }

    @Test
    @Order(2)
    public void errEventTypeById()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/helper/eventType/44")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    @Order(3)
    public void findEventTypeByEventName()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/helper/eventType/findByEventName/ID_MEETING")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(JsonEventType))
                .andReturn();
    }

    @Test
    @Order(4)
    public void errFindEvenTypeByEventName()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/helper/eventType/findByEventName/ID_ERROR")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andDo(print());

    }
}
