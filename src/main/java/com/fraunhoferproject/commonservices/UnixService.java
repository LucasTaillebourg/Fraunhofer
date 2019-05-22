package com.fraunhoferproject.commonservices;

import org.springframework.stereotype.Service;

/**
 * A service use to know the current unix timestamps
 */
@Service
public class UnixService {

    /**
     * Calculate the unix timestamp using the system current time 
     * @return the current unix timestamp
     */
    public long generateUnixCurrentTimestamp(){
        return System.currentTimeMillis() / 1000L;
    }
}
