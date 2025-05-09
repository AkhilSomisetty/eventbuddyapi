package com.eventbuddy.eventbuddyapi.service;

import com.eventbuddy.eventbuddyapi.dto.EventRequest;
import com.eventbuddy.eventbuddyapi.dto.EventResponse;
import com.eventbuddy.eventbuddyapi.model.Event;
import com.eventbuddy.eventbuddyapi.repository.EventRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EventServiceTest {

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventService eventService;

    @Test
    void testCreateEvent() {
        EventRequest request = new EventRequest();
        request.setName("Demo Event");
        request.setDescription("Some Desc");
        request.setStartDate(LocalDate.now().plusDays(1));
        request.setEndDate(LocalDate.now().plusDays(2));
        request.setLocation("Demo Location");

        Event savedEvent = new Event();
        savedEvent.setId(1L);
        savedEvent.setName("Demo Event");
        savedEvent.setDescription("Some Desc");
        savedEvent.setStartDate(request.getStartDate());
        savedEvent.setEndDate(request.getEndDate());
        savedEvent.setLocation("Demo Location");

        when(eventRepository.save(any(Event.class))).thenReturn(savedEvent);

        EventResponse result = eventService.createEvent(request);

        assertNotNull(result);
        assertEquals("Demo Event", result.getName());
        assertEquals("Some Desc", result.getDescription());
    }

    @Test
    void testGetEventById_Found() {
        Event event = new Event();
        event.setId(1L);
        event.setName("Found Event");

        when(eventRepository.findById(1L)).thenReturn(Optional.of(event));

        Optional<EventResponse> response = eventService.getEventById(1L);
        assertTrue(response.isPresent());
        assertEquals("Found Event", response.get().getName());
    }

    @Test
    void testGetEventById_NotFound() {
        when(eventRepository.findById(999L)).thenReturn(Optional.empty());

        Optional<EventResponse> response = eventService.getEventById(999L);
        assertFalse(response.isPresent());
    }
}
