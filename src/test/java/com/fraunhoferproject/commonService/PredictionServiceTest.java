package com.fraunhoferproject.commonService;

import com.fraunhoferproject.commonservices.PredictionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("Test du mappeur d'echeance")
@ExtendWith(MockitoExtension.class)
class PredictionServiceTest {
    @Mock Environment env;
    
    private PredictionService predictionService;
    
    @Test
    @DisplayName("Should return the environement prediction")
    void should_return_the_environement_prediction(){
        when(env.getProperty("prediction")).thenReturn("5");
        
        predictionService = new PredictionService(env);
        
        int result = predictionService.generatePrediction();
        
        assertThat(result).isEqualTo(5);
        verify(env, times(1)).getProperty("prediction");
    }

    @Test
    @DisplayName("Should return throw a numberFormatException if the environement prediction return anything but an int")
    void should_throw_a_number_format_exception_if_env_return_anything_but_int(){
        when(env.getProperty("prediction")).thenReturn("chain");

        predictionService = new PredictionService(env);
        
        Assertions.assertThrows(NumberFormatException.class, () -> {
            predictionService.generatePrediction();
        });
    }
}