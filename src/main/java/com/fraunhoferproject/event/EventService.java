package com.fraunhoferproject.event;

import com.fraunhoferproject.commonservices.PredictionService;
import com.fraunhoferproject.commonservices.UnixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * The service which generate an event
 */
@Service
public class EventService {

    /**
     * The description of an event by default
     */
    private static final String DEFAULT_EVENT_DESCRIPTION = "I am an event";
    /**
     * The name of an event by default
     */
    private static final String DEFAULT_EVENT_NAME = "Generated Event";

    /**
     * Service which generates the prediction
     */
    private PredictionService predictionService;
    /**
     * Service which calculates the current unix time
     */
    private UnixService unixService;

    @Autowired
    public EventService(PredictionService predictionService, UnixService unixService) {
        this.predictionService = predictionService;
        this.unixService = unixService;
    }


    /**
     * The method which generates a new event
     * @return the new event
     */
    public EventModel generateEvent() {
        return EventModel.builder()
            .id(UUID.randomUUID())
            .description(DEFAULT_EVENT_DESCRIPTION)
            .name(DEFAULT_EVENT_NAME)
            .prediction(predictionService.generatePrediction())
            .unixTime(unixService.generateUnixCurrentTimestamp())
            .build();
    }
}
