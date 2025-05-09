package com.eventbuddy.eventbuddyapi.repository;


import com.eventbuddy.eventbuddyapi.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
