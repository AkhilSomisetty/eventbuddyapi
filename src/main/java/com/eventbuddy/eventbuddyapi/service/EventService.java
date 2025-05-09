//package com.eventbuddy.eventbuddyapi.service;
//
//import com.eventbuddy.eventbuddyapi.model.Event;
//import java.util.List;
//import java.util.Optional;
//import com.eventbuddy.eventbuddyapi.dto.EventRequest;
//import com.eventbuddy.eventbuddyapi.dto.EventResponse;
//public interface EventService {
//    Event createEvent(Event event);
//    List<Event> getAllEvents();
//    Optional<Event> getEventById(Long id);
//    Event updateEvent(Long id, Event event);
//    void deleteEvent(Long id);
//    EventResponse createEvent(EventRequest request);
//    EventResponse updateEvent(Long id, EventRequest request);
//}

package com.eventbuddy.eventbuddyapi.service;

import com.eventbuddy.eventbuddyapi.dto.EventRequest;
import com.eventbuddy.eventbuddyapi.dto.EventResponse;

import java.util.List;
import java.util.Optional;

public interface EventService {
    EventResponse createEvent(EventRequest request);
    List<EventResponse> getAllEvents();
    Optional<EventResponse> getEventById(Long id);
    EventResponse updateEvent(Long id, EventRequest request);
    void deleteEvent(Long id);
}


