package com.eventbuddy.eventbuddyapi.controller;

import com.eventbuddy.eventbuddyapi.dto.EventRequest;
import com.eventbuddy.eventbuddyapi.dto.EventResponse;
import com.eventbuddy.eventbuddyapi.service.EventService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EventController.class)
class EventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventService eventService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateEvent() throws Exception {
        EventRequest request = new EventRequest();
        request.setName("Test Event");
        request.setDescription("Test Description");
        request.setStartDate(LocalDate.now().plusDays(1));
        request.setEndDate(LocalDate.now().plusDays(2));
        request.setLocation("Test Location");

        EventResponse response = new EventResponse();
        response.setId(1L);
        response.setName("Test Event");
        response.setDescription("Test Description");
        response.setStartDate(request.getStartDate());
        response.setEndDate(request.getEndDate());
        response.setLocation("Test Location");

        Mockito.when(eventService.createEvent(Mockito.any(EventRequest.class))).thenReturn(response);

        mockMvc.perform(post("/eventbuddyapi/events")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Test Event"))
                .andExpect(jsonPath("$.description").value("Test Description"))
                .andExpect(jsonPath("$.location").value("Test Location"));
    }

    @Test
    void testGetAllEvents() throws Exception {
        EventResponse response = new EventResponse();
        response.setId(1L);
        response.setName("Sample Event");

        Mockito.when(eventService.getAllEvents()).thenReturn(Collections.singletonList(response));

        mockMvc.perform(get("/eventbuddyapi/events"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Sample Event"));
    }

    @Test
    void testGetEventById() throws Exception {
        EventResponse response = new EventResponse();
        response.setId(1L);
        response.setName("Event1");

        Mockito.when(eventService.getEventById(1L)).thenReturn(Optional.of(response));

        mockMvc.perform(get("/eventbuddyapi/events/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Event1"));
    }

    @Test
    void testGetEventById_NotFound() throws Exception {
        Mockito.when(eventService.getEventById(99L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/eventbuddyapi/events/99"))
                .andExpect(status().isNotFound());
    }
}
