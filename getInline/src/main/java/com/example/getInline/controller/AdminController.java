package com.example.getInline.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/places")
    public String adminPlace() {
        return "admin/places";
    }

    @GetMapping("/places/{placeId}")
    public String adminPlaceDetail(@PathVariable Integer placeId) {
        return "admin/place-detail";
    }

    @GetMapping("/events")
    public String adminEvents() {
        return "admin/events";
    }

    @GetMapping("/events/{eventId}")
    public String adminEventDetail(@PathVariable Integer eventId) {
        return "admin/event-detail";
    }
}
