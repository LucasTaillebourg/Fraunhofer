package com.fraunhoferproject.event;

import com.fraunhoferproject.commonservices.PredictionService;
import com.fraunhoferproject.commonservices.UUIDService;
import com.fraunhoferproject.commonservices.UnixService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@DisplayName("Event service test")
@ExtendWith(MockitoExtension.class)
class EventServiceTest {
    
    @Mock private PredictionService predictionService;
    @Mock private UnixService unixService;
    @Mock private UUIDService uuidService;
    
    private EventService eventService;
    
    @Test
    @DisplayName("Event should be generate with correct information")
    void test_normal_event_building(){
        UUID uuid = UUID.fromString("feec8a0c-a97d-46dc-abfd-286ae420bee5");
        long time = 1558534178L;
        int prediction =7;
        String name = "Generated Event";
        String description = "I am an event" ;
        
        when(uuidService.generateUUID()).thenReturn(uuid);
        when(unixService.generateUnixCurrentTimestamp()).thenReturn(time);
        when(predictionService.generatePrediction()).thenReturn(prediction);
        
        eventService = new EventService(predictionService, unixService, uuidService);
        
        EventModel eventModel = eventService.generateEvent();
        
        assertThat(eventModel).isNotNull();
        assertThat(eventModel.getPrediction()).isEqualTo(prediction);
        assertThat(eventModel.getId()).isEqualByComparingTo(uuid);
        assertThat(eventModel.getUnixTime()).isEqualTo(time);
        assertThat(eventModel.getDescription()).isEqualTo(description);
        assertThat(eventModel.getName()).isEqualTo(name);
    }
}
