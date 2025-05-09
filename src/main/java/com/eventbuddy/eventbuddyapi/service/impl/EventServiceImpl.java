package com.eventbuddy.eventbuddyapi.service.impl;

import com.eventbuddy.eventbuddyapi.dto.EventRequest;
import com.eventbuddy.eventbuddyapi.dto.EventResponse;
import com.eventbuddy.eventbuddyapi.exception.ResourceNotFoundException;
import com.eventbuddy.eventbuddyapi.model.Event;
import com.eventbuddy.eventbuddyapi.repository.EventRepository;
import com.eventbuddy.eventbuddyapi.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public EventResponse createEvent(EventRequest request) {
        Event event = mapToEntity(request);
        Event saved = eventRepository.save(event);
        return mapToResponse(saved);
    }

    @Override
    public List<EventResponse> getAllEvents() {
        return eventRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList()); // use collect() instead of .toList() for better compatibility
    }

    @Override
    public Optional<EventResponse> getEventById(Long id) {
        return eventRepository.findById(id)
                .map(this::mapToResponse);
    }

    @Override
    public EventResponse updateEvent(Long id, EventRequest request) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event", "id", id));

        event.setName(request.getName());
        event.setDescription(request.getDescription());
        event.setStartDate(request.getStartDate());
        event.setEndDate(request.getEndDate());
        event.setLocation(request.getLocation());

        return mapToResponse(eventRepository.save(event));
    }

    @Override
    public void deleteEvent(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event", "id", id));
        eventRepository.delete(event);
    }

    // --- Mappers ---

    private Event mapToEntity(EventRequest request) {
        Event event = new Event();
        event.setName(request.getName());
        event.setDescription(request.getDescription());
        event.setStartDate(request.getStartDate());
        event.setEndDate(request.getEndDate());
        event.setLocation(request.getLocation());
        return event;
    }

    private EventResponse mapToResponse(Event event) {
        EventResponse response = new EventResponse();
        response.setId(event.getId());
        response.setName(event.getName());
        response.setDescription(event.getDescription());
        response.setStartDate(event.getStartDate());
        response.setEndDate(event.getEndDate());
        response.setLocation(event.getLocation());
        return response;
    }
}
