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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ContextConfiguration(classes = PlannerRestApplication.class)
public class EventSelecTest {
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
            "        \"uidEnvent\": 9,\n" +
            "        \"description\": \"Appuntamento con Alberto\",\n" +
            "        \"eventType\": {\n" +
            "            \"uidEventType\": 2,\n" +
            "            \"eventName\": \"ID_MEETING\"\n" +
            "        },\n" +
            "        \"user\": {\n" +
            "            \"uidUser\": 1,\n" +
            "            \"name\": \"Giuditta\",\n" +
            "            \"surname\": \"Marino\",\n" +
            "            \"username\": \"giudittaMar@mail.com\"\n" +
            "        }\n" +
            "    }";
    @Test
    @Order(1)
    public void findByUidEvent()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/planner/event/findById/9")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(jsonEvent))
                .andReturn();
    }

    @Test
    @Order(2)
    public void errorFindByUidEvent()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/planner/event/findById/125"))
                .andExpect(status().isNotFound())
                .andDo(print());
    }
}
