package com.fraunhoferproject.commonservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

/**
 * Service which create random UUID
 */
@Service
public class UUIDService {


    /**
     * The UUID property key
     */
    private static final String UUID_PROPERTY_KEY = "uuid";
    
    /**
     * The environement which generate a random value in application.properties
     */
    private Environment env;

    @Autowired
    public UUIDService(Environment env){
        this.env = env;
    }
    /**
     * Generate a random UUID
     * @return ab UUID
     */
    public UUID generateUUID(){
        return UUID.fromString(Objects.requireNonNull(env.getProperty(UUID_PROPERTY_KEY)));
    }
}
