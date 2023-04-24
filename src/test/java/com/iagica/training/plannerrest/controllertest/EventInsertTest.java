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
public class EventInsertTest {
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

    String jsonEvent = "{\n" +
            "    \"description\":\"Appuntamento con Bernardino\",\n" +
            "    \"eventType\":{\n" +
            "    \"uidEventType\":2,\n" +
            "    \"createdAt\":null,\n" +
            "    \"updateAt\":null\n" +
            "},\n" +
            "    \"user\":{\n" +
            "        \"uidUser\":3\n" +
            "    }\n" +
            "}";
    @Test
    @Order(1)
    public void insertEvent()throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.post("/api/planner/event/insert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonEvent)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
    String jsonEventERR1 = "{\n" +
            "    \"description\":\"Appuntamento con Bernardino\",\n" +
            "    \"eventType\":{\n" +
            "    \"uidEventType\":1,\n" +
            "    \"createdAt\":null,\n" +
            "    \"updateAt\":null\n" +
            "},\n" +
            "    \"user\":{\n" +
            "        \"uidUser\":3\n" +
            "    }\n" +
            "}";

    @Test
    @Order(2)
    public void errInsertEvent()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/api/planner/event/insert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonEventERR1)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(500))
                .andDo(print());
    };

    String jsonUpdateEvent ="{\n" +
            "        \"uidEnvent\": 49,\n" +
            "        \"description\": \"Appuntamento con Gianfranco\",\n" +
            "        \"eventType\": {\n" +
            "            \"uidEventType\": 2,\n" +
            "            \"eventName\": \"ID_MEETING\"\n" +
            "        },\n" +
            "        \"user\": {\n" +
            "            \"uidUser\": 3,\n" +
            "            \"name\": \"Riccardo\",\n" +
            "            \"surname\": \"Bagaglini\",\n" +
            "            \"username\": \"riccardoBag@mail.com\"\n" +
            "        }\n" +
            "    }";

    @Test
    @Order(3)
    public void updateEvent()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/api/planner/event/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonUpdateEvent))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @Order(4)
    public void deleteEvent()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/planner/event/delete/53")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
