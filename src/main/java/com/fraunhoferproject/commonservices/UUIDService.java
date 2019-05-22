package com.fraunhoferproject.commonservices;

import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Service which create random UUID
 */
@Service
public class UUIDService {

    /**
     * Generate a random UUID
     * @return ab UUID
     */
    public UUID generateUUID(){
        return UUID.randomUUID();
    }
}
