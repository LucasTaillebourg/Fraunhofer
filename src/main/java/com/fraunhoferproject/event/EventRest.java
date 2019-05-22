package com.fraunhoferproject.event;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A controller giving an API point to get an event
 */
@RestController
public class EventRest {

    /**   
     * The service which generate the event
     */
    private EventService eventService;

    @Autowired
    public EventRest(EventService eventService) {
        this.eventService = eventService;
    }

    /**
     * The API point for getting an event.
     * Respond on a GET request wihtout parameters
     * @return a newly created event only if the prediction is over 30
     */
    @GetMapping("/generateEvent")
    @ApiOperation(value = "Génère un event et le renvoie si sa prédiction est supérieure ou égale à 30%")
    public EventModel generateEvent() {
        EventModel result = eventService.generateEvent();
        
        if(result.getPrediction() >= 30 ){
            return result;
        }
        
        return null;
    }
    
}
