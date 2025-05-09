package com.eventbuddy.eventbuddyapi.dto;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

public class EventRequest {

    @NotBlank(message = "Name is required")
    private String name;

    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    @NotBlank(message = "Location is required")
    private String location;

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
