package com.fraunhoferproject.event;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@DisplayName("Event rest test")
@ExtendWith(MockitoExtension.class)
class EventRestTest {
    
    @Mock private EventService eventService;
    
    private EventRest eventRest;
    
    @Test
    @DisplayName("Generate event should return null if prediction is lower than 30")
    void generate_event_return_null_if_prediction_lower_than_30(){

        int prediction =7;
        
        EventModel eventModel = EventModel.builder()
            .prediction(prediction)
            .build();
        
        when(eventService.generateEvent()).thenReturn(eventModel);
        
        eventRest = new EventRest(eventService);
        
        EventModel result = eventRest.generateEvent();
        
        assertThat(result).isNull();
    }

    @Test
    @DisplayName("Generate event should return the event if prediction is higher than 30")
    void generate_event_return_prediction_if_prediction_higher_than_30(){


        UUID uuid = UUID.fromString("feec8a0c-a97d-46dc-abfd-286ae420bee5");
        long time = 1558534178L;
        String name = "Generated Event";
        int prediction = 55;
        String description = "I am an event" ;
        
        EventModel eventModel = EventModel.builder()
            .prediction(prediction)
            .id(uuid)
            .name(name)
            .unixTime(time)
            .description(description)
            .build();

        when(eventService.generateEvent()).thenReturn(eventModel);

        eventRest = new EventRest(eventService);

        EventModel result = eventRest.generateEvent();

        assertThat(result).isNotNull();
        assertThat(result.getPrediction()).isEqualTo(prediction);
        assertThat(result.getName()).isEqualTo(name);
        assertThat(result.getDescription()).isEqualTo(description);
        assertThat(result.getUnixTime()).isEqualTo(time);
        assertThat(result.getId()).isEqualByComparingTo(uuid);
    }

    @Test
    @DisplayName("Generate event should return the event if prediction is 30")
    void generate_event_return_prediction_if_prediction_is_30(){


        UUID uuid = UUID.fromString("feec8a0c-a97d-46dc-abfd-286ae420bee5");
        long time = 1558534178L;
        String name = "Generated Event";
        int prediction = 30;
        String description = "I am an event" ;

        EventModel eventModel = EventModel.builder()
            .prediction(prediction)
            .id(uuid)
            .name(name)
            .unixTime(time)
            .description(description)
            .build();

        when(eventService.generateEvent()).thenReturn(eventModel);

        eventRest = new EventRest(eventService);

        EventModel result = eventRest.generateEvent();

        assertThat(result).isNotNull();
        assertThat(result.getPrediction()).isEqualTo(prediction);
        assertThat(result.getName()).isEqualTo(name);
        assertThat(result.getDescription()).isEqualTo(description);
        assertThat(result.getUnixTime()).isEqualTo(time);
        assertThat(result.getId()).isEqualByComparingTo(uuid);
    }
    
}
