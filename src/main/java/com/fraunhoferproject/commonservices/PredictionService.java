package com.fraunhoferproject.commonservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PredictionService {

    @Autowired
    private Environment env;
    
    public int generatePrediction(){
        return new Integer(Objects.requireNonNull(env.getProperty("prediction")));
    }
    
}
