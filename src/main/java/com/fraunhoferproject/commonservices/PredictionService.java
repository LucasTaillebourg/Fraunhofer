package com.fraunhoferproject.commonservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * A service which generate the event prediction
 */
@Service
public class PredictionService {

    /**
     * The envirronement which generate a random value in application.properties
     */
    @Autowired
    private Environment env;

    /**
     * Generate a prediction between 0 and 100
     * @return a prediction
     */
    public int generatePrediction(){
        return new Integer(Objects.requireNonNull(env.getProperty("prediction")));
    }
    
}
