package com.fraunhoferproject.event;

import com.fraunhoferproject.commonservices.PredictionService;
import com.fraunhoferproject.commonservices.UnixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EventService {
    
    private PredictionService predictionService;
    private UnixService unixService;

    @Autowired
    public EventService(PredictionService predictionService, UnixService unixService) {
        this.predictionService = predictionService;
        this.unixService = unixService;
    }


    public EventModel generateEvent() {
        return EventModel.builder()
            .id(UUID.randomUUID())
            .description("I am an event")
            .name("Generated Event")
            .prediction(predictionService.generatePrediction())
            .unixTime(unixService.generateUnixCurrentTimestamp())
            .build();
    }
}
