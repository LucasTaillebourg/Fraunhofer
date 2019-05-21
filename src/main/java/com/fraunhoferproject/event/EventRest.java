package com.fraunhoferproject.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventRest {

    private EventService eventService;

    @Autowired
    public EventRest(EventService eventService) {
        this.eventService = eventService;
    }
    
    @GetMapping("/generateEvent")
    public EventModel generateEvent() {
        EventModel result = eventService.generateEvent();
        
        if(result.getPrediction() > 30 ){
            return result;
        }
        
        return null;
    }
    
}
