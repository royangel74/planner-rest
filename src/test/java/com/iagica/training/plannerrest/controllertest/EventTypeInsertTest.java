package com.iagica.training.plannerrest.controllertest;

import com.iagica.training.plannerrest.PlannerRestApplication;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@ContextConfiguration(classes = PlannerRestApplication.class)
public class EventTypeInsertTest {

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

    String jsonEvent ="{\n" +
            "    \"eventName\":\"ID_PROVA\"\n" +
            "}";
    @Test
    @Order(1)
    public void insertEventType()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/api/helper/evenType/insert")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonEvent)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

    }
    @Test
    @Order(2)
    public void errorInsertEventType()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/api/helper/evenType/insert")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonEvent)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotAcceptable())
                .andDo(print());
    }

    String updateJsonEventType ="{\n" +
            "    \"uidEventType\": \"5\",\n" +
            "    \"eventName\": \"ID_TEST\"\n" +
            "}";
    @Test
    @Order(3)
    public void updateEventType()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/api/helper/eventType/editEventType")
                .contentType(MediaType.APPLICATION_JSON)
                .content(updateJsonEventType))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    @Order(4)
    public void deleteEventType()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/helper/eventType/delete/5")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
